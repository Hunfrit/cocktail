package com.example.cocktailtest.mvp.presenters

import com.example.cocktailtest.R
import com.example.cocktailtest.api.DefaultCallback
import com.example.cocktailtest.api.RestClient
import com.example.cocktailtest.data.responses.DrinksResponse
import com.example.cocktailtest.extensions.getString
import com.example.cocktailtest.mvp.contracts.DrinksContract
import retrofit2.Call

class DrinksPresenter(override val view: DrinksContract.View) : DrinksContract.Presenter {

    override fun getOrdinaryDrinks() = RestClient.api.getOrdinaryDrinks().enqueue(object : DefaultCallback<DrinksResponse>(view) {
        override fun onResponse(body: DrinksResponse) {
            val modifiedList = body.drinks.apply {
                if (this.isNotEmpty())
                    this[0].cocktailType = getString(R.string.drink_type_ordinary)
            }
            view.retrieveOrdinaryDrinks(modifiedList)
        }

        override fun onFailure(call: Call<DrinksResponse>?, t: Throwable?) {
            super.onFailure(call, t)
            view.retrieveFailed()
        }
    })

    override fun getCocktails() = RestClient.api.getCocktails().enqueue(object : DefaultCallback<DrinksResponse>(view) {
        override fun onResponse(body: DrinksResponse) {
            val modifiedList = body.drinks.apply {
                if (this.isNotEmpty())
                    this[0].cocktailType = getString(R.string.drink_type_cocktail)
            }
            view.retrieveOrdinaryDrinks(modifiedList)
        }

        override fun onFailure(call: Call<DrinksResponse>?, t: Throwable?) {
            super.onFailure(call, t)
            view.retrieveFailed()
        }
    })
}