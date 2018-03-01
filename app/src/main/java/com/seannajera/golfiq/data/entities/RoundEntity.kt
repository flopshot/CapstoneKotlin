package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(indices = [Index(value = ["courseId"])])
data class RoundEntity(var courseId: String, var createdAt: Date, var updatedAt: Date) {
    @PrimaryKey var id: String = ""
}