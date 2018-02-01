package com.seannajera.golfiq.ui.activities

import android.support.v4.app.Fragment
import com.seannajera.golfiq.injection.Injectable
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseHasFragmentInjectorActivity(layoutId: Int): BaseActivity(layoutId),
        HasSupportFragmentInjector, Injectable {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

}