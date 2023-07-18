package com.example.pizzaorderingcomplexanimation.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaorderingcomplexanimation.R
import com.example.pizzaorderingcomplexanimation.ui.theme.brown

@Composable
fun ButtonAddToCart() {
    TextButton(
        modifier = Modifier.size(200.dp, 50.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(brown),
        shape = RoundedCornerShape(16.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_shopping_cart),
            contentDescription = "Add To Cart Button",
            Modifier.padding(end = 16.dp),
            tint = Color.White
        )
        Text(
            text = "Add To Cart",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}