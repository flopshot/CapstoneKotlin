package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(indices = [(Index(value = ["clubId"]))])
data class CourseEntity(var clubId: String, var courseName: String, var par: Int, var createdAt: Date, var updatedAt: Date) {

    @PrimaryKey var id: String = ""

}