package com.seannajera.golfiq.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
class Course(var courseName: String, var clubName: String,
              var holeCount: Int, var createdAt: Date, var updatedAt: Date) {

    @PrimaryKey(autoGenerate = true) var id: Long = 0

}