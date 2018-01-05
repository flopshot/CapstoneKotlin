package com.seannajera.golfiq.model.persistenceDb.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [(ForeignKey(entity = Course::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("courseId"),
        onDelete = ForeignKey.CASCADE))])
class CourseHoles(var courseId: Int, var holeNumber: Int, var holePar: Int,
                  var holeDistance: Int, var holeHandicap: Int) {

    @PrimaryKey(autoGenerate = true) var id: Long = 0
}