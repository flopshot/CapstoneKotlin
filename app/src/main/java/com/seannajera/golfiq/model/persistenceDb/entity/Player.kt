package com.seannajera.golfiq.model.persistenceDb.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
class Player(var firstName: String, var lastName: String, var handicap: Int,
             var createdAt: Date, var updatedAt: Date) {

    @PrimaryKey(autoGenerate = true) var id: Long = 0

}