package com.example.cocktailtest.preferences

import com.example.cocktailtest.extensions.appContext
import org.jetbrains.anko.defaultSharedPreferences


object AppPreferences {

    private val sPrefs = appContext.defaultSharedPreferences

    fun clear() {
        sPrefs.edit().clear().apply()
    }
}
