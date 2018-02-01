package com.seannajera.golfiq.injection

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.seannajera.golfiq.ui.activities.BaseHasFragmentInjectorActivity
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

interface Injectable {

    companion object {
        fun handleActivity(activity: Activity) {
            if (activity is Injectable) {
                AndroidInjection.inject(activity)
            }

            if (activity is BaseHasFragmentInjectorActivity) {
                (activity as FragmentActivity).supportFragmentManager
                        .registerFragmentLifecycleCallbacks(
                                object : FragmentManager.FragmentLifecycleCallbacks() {
                                    override fun onFragmentCreated(fm: FragmentManager, f: Fragment,
                                                                   savedInstanceState: Bundle?) {
                                        if (f is Injectable) {
                                            AndroidSupportInjection.inject(f)
                                        }
                                    }
                                }, true)
            }
        }
    }
}