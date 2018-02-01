package com.seannajera.golfiq

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.seannajera.golfiq.injection.Injectable
import com.seannajera.golfiq.injection.Injectable.Companion.handleActivity
import com.seannajera.golfiq.injection.components.DaggerApplicationComponent

object ActivityLifecycleListener {

    fun init(app: GolfIqApplication) {
        DaggerApplicationComponent.builder().application(app).build().injectApplicationComponent(app)

        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                app.activityCreatedList.add(activity::class.java.name)
                Injectable.handleActivity(activity)
            }
            override fun onActivityStarted(activity: Activity) {handleActivity(activity)}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {
                if (activity.isFinishing) {
                    app.activityCreatedList.remove(activity::class.java.name)
                }
            }
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })
    }

}