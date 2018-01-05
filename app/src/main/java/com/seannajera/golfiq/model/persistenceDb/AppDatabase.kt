package com.seannajera.golfiq.model.persistenceDb

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.seannajera.golfiq.model.persistenceDb.entity.*

@TypeConverters(value = [DateConverters::class])
@Database(entities = [Player::class, Course::class, Round::class, CourseHoles::class,
RoundPlayers::class, RoundPlayerCourseHoles::class, MarkerLocation::class, UserLocation::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()