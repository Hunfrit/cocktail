package com.example.cocktailtest.skeleton

import com.example.cocktailtest.skeleton.presentation.BasePresenter
import com.example.cocktailtest.skeleton.presentation.BaseView

class EmptyPresenter(override val view: BaseView) :
    BasePresenter<BaseView>
