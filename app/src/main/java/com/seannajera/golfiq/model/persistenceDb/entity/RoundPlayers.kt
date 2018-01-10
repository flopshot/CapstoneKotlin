package com.seannajera.golfiq.model.persistenceDb.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Player::class,
                parentColumns = ["id"],
                childColumns = ["playerId"],
                onDelete = ForeignKey.CASCADE),
            ForeignKey(entity = Round::class,
                parentColumns = ["id"],
                childColumns = ["roundId"],
                onDelete = ForeignKey.CASCADE)],
        indices = [Index(value = ["roundId"]), Index(value = ["playerId"])]
)
class RoundPlayers(var roundId: Long, var playerId: Long, var playerOrder: Int) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}