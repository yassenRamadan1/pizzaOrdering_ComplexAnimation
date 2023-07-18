package com.example.pizzaorderingcomplexanimation.pizzaui.model

import com.example.pizzaorderingcomplexanimation.R

data class Toppings(
    val name: Topping= Topping.BASIL,
    val imageRef:Int= R.drawable.basil_1,
    val groupImageRef:Int=R.drawable.group_basil,
    val isSelected:Boolean=false,
)
