package com.example.pizzaorderingcomplexanimation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextPizzaSize(text: String, onClick: () -> Unit,interactionSource:MutableInteractionSource) {
    Text(
        modifier = Modifier.clickable(onClick = onClick,
            interactionSource = interactionSource,
            indication = null ),
        text = text, fontSize = 24.sp, color = Color.Black, fontWeight = FontWeight.Medium
    )
}