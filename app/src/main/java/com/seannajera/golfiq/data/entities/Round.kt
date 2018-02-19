package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(foreignKeys = [ForeignKey(entity = Course::class,
                                    parentColumns = arrayOf("id"),
                                    childColumns = arrayOf("courseId"),
                                    onDelete = ForeignKey.CASCADE)],
        indices = [Index(value = ["courseId"])])
class Round(var courseId: Long, var createdAt: Date, var updatedAt: Date) {

    @PrimaryKey(autoGenerate = true) var id: Long = 0
}