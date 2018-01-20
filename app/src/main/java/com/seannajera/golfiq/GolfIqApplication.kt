package com.seannajera.golfiq

import android.app.Activity
import android.app.Application
import android.util.Log
import com.seannajera.golfiq.injection.modules.ComponentInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject


class GolfIqApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        ComponentInjector.init(this)

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

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}