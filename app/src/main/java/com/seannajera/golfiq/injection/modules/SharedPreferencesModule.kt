package com.seannajera.golfiq.injection.modules

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.seannajera.golfiq.GolfIqApplication
import com.seannajera.golfiq.injection.DefaultSharedPrefs
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule {

    @Provides
    @DefaultSharedPrefs
    fun getDefaultSharedPreferences(appContext: GolfIqApplication): SharedPreferences
            = PreferenceManager.getDefaultSharedPreferences(appContext)
}