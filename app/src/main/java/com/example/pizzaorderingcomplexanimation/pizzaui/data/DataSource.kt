package com.example.pizzaorderingcomplexanimation.pizzaui.data

import com.example.pizzaorderingcomplexanimation.R
import com.example.pizzaorderingcomplexanimation.pizzaui.PizzaModel
import com.example.pizzaorderingcomplexanimation.pizzaui.model.PizzaSize
import com.example.pizzaorderingcomplexanimation.pizzaui.model.Topping
import com.example.pizzaorderingcomplexanimation.pizzaui.model.Toppings

object DataSource {

    private fun toppingsData(): List<Toppings> {
        return listOf(
            Toppings(
                name = Topping.BASIL,
                imageRef = R.drawable.basil_1,
                groupImageRef = R.drawable.group_basil,
                isSelected = false
            ),
            Toppings(
                name = Topping.BROCCOLI,
                imageRef = R.drawable.broccoli_1,
                groupImageRef = R.drawable.group_broccoli,
                isSelected = false
            ) ,
            Toppings(
                name = Topping.MUSHROOM,
                imageRef = R.drawable.mushroom_1,
                groupImageRef = R.drawable.group_mushroom,
                isSelected = false
            ),
            Toppings(
                name = Topping.ONION,
                imageRef = R.drawable.onion_1,
                groupImageRef = R.drawable.group_onion,
                isSelected = false
            ),
            Toppings(
                name = Topping.SAUSAGE,
                imageRef = R.drawable.sausage_1,
                groupImageRef = R.drawable.group_sausage,
                isSelected = false
            )
        )
    }
            fun pizzasData(): List<PizzaModel> {
            return listOf(
                PizzaModel(
                    pizzaSize = PizzaSize.Small,
                    bread = R.drawable.bread_1,
                    toppings = toppingsData()
                ),
                PizzaModel(
                    pizzaSize = PizzaSize.Small,
                    bread = R.drawable.bread_2,
                    toppings = toppingsData()
                ),
                PizzaModel(
                    pizzaSize = PizzaSize.Small,
                    bread = R.drawable.bread_3,
                    toppings = toppingsData()
                ),
                PizzaModel(
                    pizzaSize = PizzaSize.Small,
                    bread = R.drawable.bread_4,
                    toppings = toppingsData()
                ),
                PizzaModel(
                    pizzaSize = PizzaSize.Small,
                    bread = R.drawable.bread_5,
                    toppings = toppingsData()
                ),
            )
    }
}