package com.seannajera.golfiq.model.persistenceDb.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity()
class UserLocation(@PrimaryKey var id: Int, var lat: Double, var lon: Double, var errorMargin: Double, var createdAt: Date)