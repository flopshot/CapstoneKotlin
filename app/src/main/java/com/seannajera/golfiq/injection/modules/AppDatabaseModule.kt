package com.seannajera.golfiq.injection.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.seannajera.golfiq.model.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class AppDatabaseModule {

    @Provides
    @Synchronized
    fun getAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "golfiq-database")
                .fallbackToDestructiveMigration()
                .build()
    }
}