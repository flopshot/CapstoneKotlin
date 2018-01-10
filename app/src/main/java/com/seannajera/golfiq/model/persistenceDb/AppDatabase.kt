package com.seannajera.golfiq.model.persistenceDb

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.seannajera.golfiq.model.persistenceDb.dao.*
import com.seannajera.golfiq.model.persistenceDb.entity.*

@TypeConverters(value = [DateConverters::class])
@Database(entities = [Player::class, Course::class, Round::class, CourseHoles::class,
RoundPlayers::class, RoundPlayerCourseHoles::class, MarkerLocation::class, UserLocation::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun courseHolesDao(): CourseHolesDao
    abstract fun markerLocationDao(): MarkerLocationDao
    abstract fun playerDao(): PlayerDao
    abstract fun roundDao(): RoundDao
    abstract fun roundPlayerCourseHolesDao(): RoundPlayerCourseHolesDao
    abstract fun roundPlayersDao(): RoundPlayersDao
    abstract fun userLocationDao(): UserLocationDao
}