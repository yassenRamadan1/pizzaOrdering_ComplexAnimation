package com.example.pizzaorderingcomplexanimation.pizzaui

import com.example.pizzaorderingcomplexanimation.R
import com.example.pizzaorderingcomplexanimation.pizzaui.model.PizzaSize
import com.example.pizzaorderingcomplexanimation.pizzaui.model.Toppings

data class PizzaUiState (
        val pizzas:List<PizzaModel> = emptyList(),
        val pizzaId:Int=0,
        )
data class PizzaModel(
        val pizzaSize: PizzaSize = PizzaSize.Small,
        val bread: Int= R.drawable.bread_1,
        val toppings: List<Toppings> = emptyList()
)