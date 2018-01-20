package com.seannajera.golfiq.injection.modules

import android.arch.persistence.room.Room
import com.seannajera.golfiq.GolfIqApplication
import com.seannajera.golfiq.model.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDatabaseModule {

    @Singleton
    @Provides
    fun getAppDatabase(context: GolfIqApplication): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "golfiq-database").build()
    }
}