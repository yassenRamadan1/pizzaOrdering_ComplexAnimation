package com.example.pizzaorderingcomplexanimation.pizzaui

import androidx.lifecycle.ViewModel
import com.example.pizzaorderingcomplexanimation.pizzaui.data.DataSource
import com.example.pizzaorderingcomplexanimation.pizzaui.model.PizzaSize
import com.example.pizzaorderingcomplexanimation.pizzaui.model.Topping
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaViewModel: ViewModel() {
    private val _state = MutableStateFlow(PizzaUiState())
    val state = _state.asStateFlow()

    init {
        getPizzasData()
    }

    private fun getPizzasData() {
        _state.update{it.copy(pizzas = DataSource.pizzasData())}
    }
    fun updatePizzaId(PizzaId: Int) {
        _state.update { it.copy(pizzaId = PizzaId) }
    }
    fun onClickTopping(name: Topping, isSelected: Boolean) {
        _state.update {
            it.copy(
                pizzas = it.pizzas.mapIndexed { id, pizza ->
                    if (id == _state.value.pizzaId) {
                        pizza.copy(toppings = pizza.toppings.map { topping ->
                            if (topping.name == name) {
                                topping.copy(isSelected = isSelected)
                            } else {
                                topping
                            }
                        })
                    } else {
                        pizza
                    }
                }
            )
        }
    }
    fun onChangeSize(pizzaSize: PizzaSize) {
        _state.update {
            it.copy(pizzas = it.pizzas.mapIndexed { id, pizza ->
                if (id == _state.value.pizzaId) {
                    pizza.copy(pizzaSize = pizzaSize)
                } else {
                    pizza
                }
            })
        }
    }


}