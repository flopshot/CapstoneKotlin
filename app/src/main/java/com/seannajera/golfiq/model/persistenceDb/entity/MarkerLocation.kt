package com.seannajera.golfiq.model.persistenceDb.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity()
class MarkerLocation(@PrimaryKey var id: Long, var lat: Double, var lon: Double, var createdAt: Date)