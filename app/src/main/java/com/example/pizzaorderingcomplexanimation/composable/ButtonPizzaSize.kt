package com.example.pizzaorderingcomplexanimation.composable

import android.view.animation.ScaleAnimation
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateIntSizeAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ButtonPizzaSize(text: String, isSelected: Boolean, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.size(50.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(Color.White),
        elevation = if (isSelected) ButtonDefaults
            .buttonElevation(animateIntAsState(targetValue = 4,
                animationSpec =tween(durationMillis = 100,
                    easing = FastOutSlowInEasing) ).value.dp) else ButtonDefaults
            .buttonElevation(animateIntAsState(targetValue = 0,
                animationSpec =tween(durationMillis = 100,
                    easing = FastOutSlowInEasing) ).value.dp)
    ) {
            Text(
                text = text, fontSize = 24.sp, color = Color.Black, fontWeight = FontWeight.Medium
            )
    }
}