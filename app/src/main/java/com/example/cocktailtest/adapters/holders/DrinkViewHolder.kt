package com.example.cocktailtest.adapters.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cocktailtest.data.models.DrinkModel
import com.example.cocktailtest.extensions.gone
import com.example.cocktailtest.extensions.load
import com.example.cocktailtest.extensions.visible
import kotlinx.android.synthetic.main.item_drink.view.*

/**
 * Created by Artem on 25.04.2019.
 * company - A2Lab
 */

class DrinkViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTitle = view.tvDrinkTypeTitle
    private val ivDrink = view.ivDrink
    private val tvDescription = view.tvDrinkDescription

    fun bindDrink(item: DrinkModel) {
        with(item) {
            // when items rendering -> tvTitle still visible on some items
            if (cocktailType.isNullOrEmpty()) {
                tvTitle.text = ""
                tvTitle.gone()
            } else {
                tvTitle.text = cocktailType
                tvTitle.visible()
            }
            tvDescription.text = title
            ivDrink.load(image)
        }
    }
}