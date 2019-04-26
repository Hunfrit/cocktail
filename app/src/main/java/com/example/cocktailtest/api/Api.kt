package com.example.cocktailtest.api

import com.example.cocktailtest.data.responses.DrinksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Contains all server requests
 */
interface Api {

    @GET("filter.php")
    fun getOrdinaryDrinks(@Query("c") ordinary_drink: String = "Ordinary_Drink"): Call<DrinksResponse>

    @GET("filter.php")
    fun getCocktails(@Query("c") ordinary_drink: String = "Cocktail"): Call<DrinksResponse>

}
