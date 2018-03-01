package com.seannajera.golfiq.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index

@Entity(primaryKeys = ["playerId", "roundId"]
        ,indices = [Index(value = ["roundId"]),Index(value = ["playerId"]), Index(value = ["roundId","playerId"])])
data class RoundPlayerEntity(var playerId: String, var roundId: String)