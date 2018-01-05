package com.seannajera.golfiq.model.persistenceDb.entity

import android.arch.persistence.room.Entity
import java.util.*

@Entity()
class UserLocation(var id: Int, var lat: Double, var lon: Double, var errorMargin: Double, var createdAt: Date)