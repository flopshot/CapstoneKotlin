package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index

@Entity(primaryKeys = ["teeId", "number"],indices = [Index(value = ["teeId"])])
data class HoleEntity(var id: String, var teeId: String, var number: Int,
                      var yards: Int, var par: Int, var handicap: Int)