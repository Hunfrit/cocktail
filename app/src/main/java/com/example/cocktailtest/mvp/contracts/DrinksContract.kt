package com.example.cocktailtest.mvp.contracts

import com.example.cocktailtest.data.models.DrinkModel
import com.example.cocktailtest.skeleton.presentation.BasePresenter
import com.example.cocktailtest.skeleton.presentation.BaseView

interface DrinksContract {

    interface View : BaseView {
        fun retrieveOrdinaryDrinks(items: List<DrinkModel>)

        fun retrieveCocktails(items: List<DrinkModel>)

        fun retrieveFailed()
    }

    interface Presenter : BasePresenter<View> {
        fun getOrdinaryDrinks()

        fun getCocktails()
    }
}