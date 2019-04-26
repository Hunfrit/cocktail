package com.example.cocktailtest.screens.fragments

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.cocktailtest.adapters.DrinksAdapter
import com.example.cocktailtest.data.models.DrinkModel
import com.example.cocktailtest.extensions.appContext
import com.example.cocktailtest.mvp.contracts.DrinksContract
import com.example.cocktailtest.mvp.presenters.DrinksPresenter
import com.example.cocktailtest.screens.MainActivity
import com.example.cocktailtest.skeleton.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_drinks.*
import org.jetbrains.anko.toast

/**
 * Created by Artem on 25.04.2019.
 * company - A2Lab
 */

class DrinksFragment : BaseFragment<MainActivity, DrinksPresenter>(), DrinksContract.View {

    private val drinkAdapter = DrinksAdapter(arrayListOf()) {
        if (it is DrinkModel) activity.toast("Clicked: ${it.title}")
    }.apply {
        addLoadingFooter()
    }

    override val TAG: String
        get() = DrinksFragment::class.java.simpleName

    override fun getLayoutId(): Int = com.example.cocktailtest.R.layout.fragment_drinks

    override fun createPresenter(): DrinksPresenter = DrinksPresenter(this)

    override fun initViews(rootView: View?) {
        initAdapter()
        presenter.getOrdinaryDrinks()
        presenter.getCocktails()
        swipeContainer.setOnRefreshListener {
            drinkAdapter.apply {
                clearItems()
                addLoadingFooter()
            }
            presenter.getOrdinaryDrinks()
            presenter.getCocktails()
        }
    }

    override fun retrieveOrdinaryDrinks(items: List<DrinkModel>) {
        drinkAdapter.addItems(items)
        if (swipeContainer != null && swipeContainer.isRefreshing) {
            swipeContainer.isRefreshing = false
        }
    }

    override fun retrieveCocktails(items: List<DrinkModel>) {
        drinkAdapter.addItems(items)
        if (swipeContainer != null && swipeContainer.isRefreshing) {
            swipeContainer.isRefreshing = false
        }
    }

    override fun retrieveFailed() {
        if (swipeContainer != null && swipeContainer.isRefreshing) {
            swipeContainer.isRefreshing = false
        }
    }

    private fun initAdapter() {
        rvDrinks.layoutManager = LinearLayoutManager(appContext)
//        rvDrinks.addItemDecoration(VerticalItemDecoration())
        //TODO: create divider in VerticalItemDecoration, not inside the item_drink
        rvDrinks.setHasFixedSize(true)
        rvDrinks.adapter = drinkAdapter
    }

}