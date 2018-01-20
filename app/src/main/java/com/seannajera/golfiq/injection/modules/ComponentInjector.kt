package com.seannajera.golfiq.injection.modules

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.seannajera.golfiq.GolfIqApplication
import com.seannajera.golfiq.injection.components.DaggerApplicationComponent
import com.seannajera.golfiq.ui.activities.BaseHasFragmentInjectorActivity
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

object ComponentInjector {

    fun init(app: GolfIqApplication) {
        DaggerApplicationComponent.builder().application(app).build().injectApplicationComponent(app)

        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }
        })
    }

    private fun handleActivity(activity: Activity) {
        AndroidInjection.inject(activity)

        if (activity is BaseHasFragmentInjectorActivity) {
            (activity as FragmentActivity).supportFragmentManager
                    .registerFragmentLifecycleCallbacks(
                            object : FragmentManager.FragmentLifecycleCallbacks() {
                                override fun onFragmentCreated(fm: FragmentManager, f: Fragment,
                                                               savedInstanceState: Bundle?) {
                                    AndroidSupportInjection.inject(f)
                                }
                            }, true)
        }
    }
}