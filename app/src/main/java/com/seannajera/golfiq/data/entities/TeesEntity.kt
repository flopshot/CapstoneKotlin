package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(indices = [(Index(value = ["id"])), (Index(value = ["courseId"]))])
data class TeesEntity(var courseId: String, var name: String, var color: String,
                 var yards: Int, var rating: Float, var slope: Int) {
    @PrimaryKey var id: String = ""
}