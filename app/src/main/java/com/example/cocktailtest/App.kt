package com.example.cocktailtest

import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.example.cocktailtest.utils.TimberCrashReportingTree
import io.fabric.sdk.android.Fabric
import net.danlew.android.joda.JodaTimeAndroid
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        JodaTimeAndroid.init(context)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Fabric.with(this, Crashlytics())
            Timber.plant(TimberCrashReportingTree())
        }
    }
    companion object {

        @Volatile
        private var instance: App? = null

        val context: Context
            get() = instance!!.applicationContext
    }
}
