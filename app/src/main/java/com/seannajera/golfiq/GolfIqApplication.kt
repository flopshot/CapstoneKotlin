package com.seannajera.golfiq

import android.app.Application
import android.util.Log
import com.seannajera.golfiq.injection.components.ApplicationComponent
import com.seannajera.golfiq.injection.components.DaggerApplicationComponent
import com.seannajera.golfiq.injection.modules.ContextModule
import com.seannajera.golfiq.model.AppDatabase
import timber.log.Timber

class GolfIqApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .contextModule(ContextModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        appDatabase = component.appDatabase()
        appContext = this

        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String {
                    return "${super.createStackElementTag(element)}-${element.lineNumber}"
                }
            })
        } else {
            Timber.plant(object : Timber.DebugTree() {
                override fun isLoggable(tag: String?, priority: Int): Boolean {
                    return (priority == Log.ERROR || priority == Log.WARN)
                }

                override fun createStackElementTag(element: StackTraceElement): String {
                    return "${super.createStackElementTag(element)}-${element.lineNumber}"
                }
            })
        }
    }

    companion object {
        lateinit var appContext: GolfIqApplication
        lateinit var appDatabase: AppDatabase
    }
}