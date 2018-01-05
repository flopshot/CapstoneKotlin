package com.seannajera.golfiq.model.persistenceDb.entity

import android.arch.persistence.room.Entity
import java.util.*

@Entity()
class MarkerLocation(var id: Int, var lat: Double, var lon: Double, var createdAt: Date)