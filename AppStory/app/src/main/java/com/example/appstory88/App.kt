package com.example.appstory88

import android.app.Application
import android.content.Context
import com.example.appstory88.utils.MyDebugTree
import timber.log.Timber

class App : Application() {
    companion object {
        lateinit var context: Context

    }


    override fun onCreate() {
        super.onCreate()
        context=applicationContext
        initLog()
    }

    private fun initLog() {
        if (BuildConfig.DEBUG) {
            Timber.plant(MyDebugTree())
        }
    }
}