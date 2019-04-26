package com.example.cocktailtest.skeleton.presentation

interface BasePresenter<V : BaseView> {
    val view: V
}
