package com.seannajera.golfiq

import android.app.Application
import android.util.Log
import timber.log.Timber

class GolfIqApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        appContext = this
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String {
                    return super.createStackElementTag(element) + "-" + element.lineNumber
                }
            })
        } else {
            Timber.plant(object : Timber.DebugTree() {
                override fun isLoggable(tag: String?, priority: Int): Boolean {
                    return (priority == Log.ERROR || priority == Log.WARN)
                }

                override fun createStackElementTag(element: StackTraceElement): String {
                    return super.createStackElementTag(element) + "-" + element.lineNumber
                }
            })
        }
    }

    companion object {
        private lateinit var appContext:GolfIqApplication
        fun get():GolfIqApplication = appContext
    }

}