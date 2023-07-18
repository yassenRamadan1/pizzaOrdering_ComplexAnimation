package com.example.pizzaorderingcomplexanimation.pizzaui

import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pizzaorderingcomplexanimation.R
import com.example.pizzaorderingcomplexanimation.composable.AppBar
import com.example.pizzaorderingcomplexanimation.composable.ButtonAddToCart
import com.example.pizzaorderingcomplexanimation.composable.ButtonPizzaSize
import com.example.pizzaorderingcomplexanimation.pizzaui.model.PizzaSize
import com.example.pizzaorderingcomplexanimation.pizzaui.model.Topping
import com.example.pizzaorderingcomplexanimation.ui.theme.lightGreen
import java.nio.file.WatchEvent


@Composable
fun PizzaScreen(
    padding: PaddingValues,
    viewModel: PizzaViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    PizzaContent(
        padding=padding,
        state = state,
        onClickTopping = viewModel::onClickTopping,
        onChangePizzaSize = viewModel::onChangeSize,
        updatePizzaId = viewModel::updatePizzaId
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun PizzaContent(
    padding: PaddingValues,
    state: PizzaUiState,
    onClickTopping: (name: Topping, isSelected: Boolean) -> Unit,
    onChangePizzaSize: (PizzaSize) -> Unit,
    updatePizzaId: (Int) -> Unit
){
    val pager = rememberPagerState()
    val size by animateFloatAsState(
        targetValue = when (state.pizzas[pager.currentPage].pizzaSize) {
            PizzaSize.Small -> 0.6f
            PizzaSize.Medium -> 0.65f
            PizzaSize.Large -> 0.7f
        })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AppBar()
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight(.5f)
                .fillMaxWidth()
        ){
            Image(
                painter = painterResource(id = R.drawable.plate),
                contentDescription = null,
                modifier = Modifier
                    .padding(42.dp)
                    .size(350.dp)
            )
            HorizontalPager(
                state = pager,
                pageCount = state.pizzas.size,
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth(),
                key = { state.pizzas[it].bread }
            ) { currentPage ->
                updatePizzaId(pager.currentPage)
                Box(
                    modifier = Modifier
                        .scale(size)
                ) {
                    Image(
                        painter = painterResource(id = state.pizzas[currentPage].bread),
                        contentDescription = "bread",
                    )
                    state.pizzas[state.pizzaId].toppings.reversed().forEach {

                        androidx.compose.animation.AnimatedVisibility(
                            visible = it.isSelected && currentPage == pager.currentPage&&!pager.isScrollInProgress ,
                            enter = scaleIn(initialScale = 2f) + fadeIn(),
                            exit = ExitTransition.None
                        ) {
                            Image(
                                painter = painterResource(id = it.groupImageRef),
                                contentDescription = null,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
        Text(
            text = stringResource(R.string._17),
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 6.dp)
        ) {
            ButtonPizzaSize(text = "s", isSelected = state.pizzas[pager.currentPage].pizzaSize==PizzaSize.Small) {
                onChangePizzaSize(PizzaSize.Small)
            }
            ButtonPizzaSize(text = "M", isSelected = state.pizzas[pager.currentPage].pizzaSize==PizzaSize.Medium) {
                onChangePizzaSize(PizzaSize.Medium)
            }
            ButtonPizzaSize(text = "L", isSelected = state.pizzas[pager.currentPage].pizzaSize==PizzaSize.Large) {
                onChangePizzaSize(PizzaSize.Large)
            }

        }
        Box(modifier = Modifier.fillMaxWidth()){
            Text(
                text = "CUSTOMIZE YOUR PIZZA",
                color = Color.Black.copy(alpha = .6f),
                modifier = Modifier
                    .padding(top = 36.dp, start = 16.dp)
            )
        }
        LazyRow(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp, bottom = 42.dp),
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(state.pizzas[state.pizzaId].toppings) { topping ->
                Image(
                    painter = painterResource(id = topping.imageRef),
                    contentDescription = "topping",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                        .background(color = if (topping.isSelected) Color(lightGreen.value) else Color.Transparent)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onClickTopping(topping.name, !topping.isSelected)
                        }
                )
            }
        }
        ButtonAddToCart()

    }


}
@Preview
@Composable
private fun Preview() {
    PizzaScreen(PaddingValues(4.dp))
}