package com.seannajera.golfiq.model.persistenceDb.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(foreignKeys = [ForeignKey(entity = Course::class,
                                    parentColumns = arrayOf("id"),
                                    childColumns = arrayOf("courseId"),
                                    onDelete = ForeignKey.CASCADE)])
class Round(var courseId: Int, var createdAt: Date, var updatedAt: Date) {

    @PrimaryKey(autoGenerate = true) var id: Long = 0
}