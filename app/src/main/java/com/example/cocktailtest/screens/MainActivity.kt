package com.example.cocktailtest.screens

import com.example.cocktailtest.R
import com.example.cocktailtest.extensions.newInstance
import com.example.cocktailtest.screens.fragments.DrinksFragment
import com.example.cocktailtest.skeleton.EmptyPresenter
import com.example.cocktailtest.skeleton.activity.BaseActivity

class MainActivity : BaseActivity<EmptyPresenter>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun createPresenter(): EmptyPresenter = EmptyPresenter(this)

    override fun initViews() {
        replaceFragment(R.id.container, newInstance<DrinksFragment>())
    }

}

