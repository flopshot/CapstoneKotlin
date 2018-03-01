package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(indices = [(Index(value = ["id"])), (Index(value = ["courseId"]))])
class TeesEntity(var courseId: String, var name: String, var color: String,
                 var yards: Int, var rating: Float, var slope: Int, var createdAt: Date,
                var updatedAt: Date) {
    @PrimaryKey var id: String = ""
}