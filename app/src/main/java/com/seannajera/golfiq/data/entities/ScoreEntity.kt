package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(indices = [Index(value = ["holeId"]), Index(value = ["roundId"]), Index(value = ["playerId"])])
data class ScoreEntity(var holeId: String, var roundId: String, var playerId: String,
                       var strokes: Int, var penalties: Int, var putts: Int,
                       var sandShots: Int, var girFlag: Int, var firFlag: Int) {
    @PrimaryKey var id: String = ""
}