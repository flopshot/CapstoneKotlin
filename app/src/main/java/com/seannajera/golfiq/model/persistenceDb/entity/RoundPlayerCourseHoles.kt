package com.seannajera.golfiq.model.persistenceDb.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [(ForeignKey(entity = RoundPlayers::class,
            parentColumns = ["id"],
            childColumns = ["roundPlayerId"],
            onDelete = ForeignKey.CASCADE)),
        ForeignKey(entity = Round::class,
                parentColumns = ["id"],
                childColumns = ["roundId"],
                onDelete = ForeignKey.CASCADE)]
)
class RoundPlayerCourseHoles(var roundPlayerId: Int, var roundId: Int, var score: Int,
                             var penalties: Int, var putts: Int, var sandShots: Int,
                             var sandFlag: Int, var girFlag: Int, var firFlag: Int,
                             var holeNumber: Int) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}