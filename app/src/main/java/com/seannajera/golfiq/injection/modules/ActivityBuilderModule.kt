package com.seannajera.golfiq.injection.modules

import com.seannajera.golfiq.ui.activities.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @Suppress("unused")
    @ContributesAndroidInjector(modules = [TabBarFragmentModuleBuilder::class])
    internal abstract fun bindCourseTabActivity(): CourseTabActivity

    @Suppress("unused")
    @ContributesAndroidInjector(modules = [TabBarFragmentModuleBuilder::class])
    internal abstract fun bindPlayerTabActivity(): PlayerTabActivity

    @Suppress("unused")
    @ContributesAndroidInjector(modules = [TabBarFragmentModuleBuilder::class])
    internal abstract fun bindRangeFinderTabActivity(): RangeFinderTabActivity

    @Suppress("unused")
    @ContributesAndroidInjector(modules = [TabBarFragmentModuleBuilder::class])
    internal abstract fun bindNewRoundTabActivity(): NewRoundTabActivity

    @Suppress("unused")
    @ContributesAndroidInjector(modules = [TabBarFragmentModuleBuilder::class])
    internal abstract fun bindOldRoundTabActivity(): OldRoundTabActivity
}