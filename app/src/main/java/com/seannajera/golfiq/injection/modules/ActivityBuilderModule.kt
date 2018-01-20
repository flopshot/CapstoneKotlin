package com.seannajera.golfiq.injection.modules

import com.seannajera.golfiq.ui.activities.TabBarActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @Suppress("unused")
    @ContributesAndroidInjector(modules = [TabBarFragmentModuleBuilder::class])
    internal abstract fun bindTabBarActivity(): TabBarActivity
}