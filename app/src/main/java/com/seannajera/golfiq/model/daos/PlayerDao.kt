package com.seannajera.golfiq.model.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.model.entities.Player

@Dao
interface PlayerDao {
    @Query("select * from Player")
    fun getAll(): List<Player>

    @Query("select * from Player where id = :id")
    fun findPlayerById(id: Long): Player

    @Insert(onConflict = REPLACE)
    fun insertPlayer(player: Player)

    @Update(onConflict = REPLACE)
    fun updatePlayer(player: Player)

    @Delete
    fun deletePlayer(player: Player)
}