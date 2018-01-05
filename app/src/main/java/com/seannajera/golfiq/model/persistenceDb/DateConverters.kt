package com.seannajera.golfiq.model.persistenceDb

import android.arch.persistence.room.TypeConverter
import java.util.*


class DateConverters {
    @TypeConverter
    fun toDate(date: Long): Date = Date(date)

    @TypeConverter
    fun fromDate(date: Date): Long = date.time
}