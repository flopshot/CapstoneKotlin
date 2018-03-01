package com.seannajera.golfiq.data.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.seannajera.golfiq.data.entities.RoundPlayerEntity

@Dao
interface RoundPlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roundPlayer: RoundPlayerEntity)

    @Query("DELETE FROM RoundPlayerEntity WHERE roundId = :roundId AND playerId = :playerId")
    fun deleteById(playerId: String, roundId: String)
}