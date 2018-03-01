package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
data class PlayerEntity(var firstName: String, var lastName: String, var handicap: Int,
                        var createdAt: Date, var updatedAt: Date) {
    @PrimaryKey var id: String = ""
}