package com.seannajera.golfiq.injection.components

import com.seannajera.golfiq.GolfIqApplication
import com.seannajera.golfiq.injection.modules.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppDatabaseModule::class, ViewModelModule::class, SharedPreferencesModule::class,
    ElevationServiceModule::class, WeatherServiceModule::class, ActivityBuilderModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: GolfIqApplication): Builder

        fun build(): ApplicationComponent
    }

    fun injectApplicationComponent(application: GolfIqApplication)
}