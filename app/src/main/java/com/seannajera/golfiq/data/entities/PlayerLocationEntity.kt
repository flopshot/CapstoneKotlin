package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity()
data class PlayerLocationEntity(@PrimaryKey var id: Long, var lat: Double, var lon: Double, var errorMargin: Double, var createdAt: Date)