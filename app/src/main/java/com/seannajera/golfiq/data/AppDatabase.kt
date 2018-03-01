package com.seannajera.golfiq.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.seannajera.golfiq.data.daos.*
import com.seannajera.golfiq.data.entities.*

@TypeConverters(value = [DateConverter::class])
@Database(entities = [PlayerEntity::class, CourseEntity::class, RoundEntity::class, ClubEntity::class,
    HoleEntity::class, ScoreEntity::class, MarkerEntity::class, PlayerLocationEntity::class, TeesEntity::class,
    RoundPlayerEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun clubDaoDao(): ClubDao
    abstract fun markerLocationDao(): MarkerLocationDao
    abstract fun playerDao(): PlayerDao
    abstract fun roundDao(): RoundDao
    abstract fun scoreDao(): ScoreDao
    abstract fun holeDao(): HoleDao
    abstract fun userLocationDao(): UserLocationDao
    abstract fun roundPlayerDao(): RoundPlayerDao
    abstract fun teesDao(): TeesDao
}