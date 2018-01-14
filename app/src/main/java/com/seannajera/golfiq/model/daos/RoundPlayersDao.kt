package com.seannajera.golfiq.model.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.model.entities.RoundPlayers

@Dao
interface RoundPlayersDao {
    @Query("select * from RoundPlayers")
    fun getAll(): List<RoundPlayers>

    @Query("select * from RoundPlayers where id = :id")
    fun findRoundPlayersById(id: Long): RoundPlayers

    @Insert(onConflict = REPLACE)
    fun insertRoundPlayers(roundPlayers: RoundPlayers)

    @Update(onConflict = REPLACE)
    fun updateRoundPlayers(roundPlayers: RoundPlayers)

    @Delete
    fun deleteRoundPlayers(roundPlayers: RoundPlayers)
}