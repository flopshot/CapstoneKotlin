package com.seannajera.golfiq.injection.modules

import com.seannajera.golfiq.presentation.fragments.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TabBarFragmentModuleBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindCoursesFragment(): CoursesFragment

    @ContributesAndroidInjector
    internal abstract fun bindOldRoundFragment(): OldRoundFragment

    @ContributesAndroidInjector
    internal abstract fun bindPlayersFragment(): PlayersFragment

    @ContributesAndroidInjector
    internal abstract fun bindPlayGolfFragment(): PlayGolfFragment

    @ContributesAndroidInjector
    internal abstract fun bindRangeFinderFragment(): RangeFinderFragment
}