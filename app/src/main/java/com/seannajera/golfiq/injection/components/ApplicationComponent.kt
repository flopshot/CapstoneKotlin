package com.seannajera.golfiq.injection.components

import com.seannajera.golfiq.injection.modules.AppDatabaseModule
import com.seannajera.golfiq.injection.modules.ContextModule
import com.seannajera.golfiq.model.AppDatabase
import dagger.Component

@Component(modules = [AppDatabaseModule::class, ContextModule::class])
interface ApplicationComponent {
    fun appDatabase():AppDatabase
}