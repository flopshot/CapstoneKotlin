package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
data class ClubEntity(var clubName:String, var telephoneNumber:String, var address: String, var createdAt: Date, var updatedAt: Date) {
    @PrimaryKey var id: String = ""
}