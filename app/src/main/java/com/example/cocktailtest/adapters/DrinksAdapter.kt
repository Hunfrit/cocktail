package com.example.cocktailtest.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.cocktailtest.R
import com.example.cocktailtest.adapters.holders.DrinkViewHolder
import com.example.cocktailtest.adapters.holders.LoadingHolder
import com.example.cocktailtest.data.models.DrinkItem
import com.example.cocktailtest.data.models.DrinkModel
import com.example.cocktailtest.extensions.inflate
import com.example.cocktailtest.utils.pagination.PaginationAdapter
import kotlinx.android.synthetic.main.item_drink.view.*

/**
 * Created by Artem on 25.04.2019.
 * company - A2Lab
 */

class DrinksAdapter(
    private val items: ArrayList<DrinkItem>,
    private val onClick: (DrinkItem) -> Unit) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>(), PaginationAdapter<DrinkItem> {

    override fun getItemViewType(position: Int): Int = when {
        items[position].id < 0 -> R.layout.item_loading_holder
        else -> R.layout.item_drink
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        R.layout.item_loading_holder -> LoadingHolder(parent.inflate(R.layout.item_loading_holder))
        R.layout.item_drink -> DrinkViewHolder(parent.inflate(R.layout.item_drink))
        else -> throw IllegalArgumentException("Wrong active task item type")
    }.apply {
        when (this){
            is DrinkViewHolder ->
                itemView.drinkContainer.setOnClickListener {
                    val selectedPosition = adapterPosition
                    if (selectedPosition != RecyclerView.NO_POSITION) {
                        onClick(items[selectedPosition])
                    }
                }
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when (holder) {
        is LoadingHolder -> Unit
        is DrinkViewHolder -> holder.bindDrink(items[position] as DrinkModel)
        else -> throw IllegalArgumentException("Wrong active task holder type")
    }

    override fun addLoadingFooter() {
        val holderPosition = items.size
        items.add(DrinkItem(-1))
        notifyItemInserted(holderPosition)
    }

    override fun removeLoadingFooter() {
        val holderPosition = items.size - 1
        //removes item only if loading footer was added
        if (holderPosition >= 0) {
            if (items[holderPosition].id > -1) return //this is not loading footer
            items.removeAt(holderPosition)
            notifyItemRemoved(holderPosition)
        }
    }

    override fun addItems(newItems: List<DrinkItem>) {
        removeLoadingFooter()
        val from = items.size
        items.addAll(newItems)
        notifyItemRangeInserted(from, newItems.size)
    }

    override fun clearItems() {
        if (items.isEmpty()) return
        items.clear()
        notifyDataSetChanged()
    }
}