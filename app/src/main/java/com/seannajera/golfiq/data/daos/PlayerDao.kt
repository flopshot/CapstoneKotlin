package com.seannajera.golfiq.data.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.data.entities.PlayerEntity

@Dao
interface PlayerDao {
    @Query("select * from PlayerEntity")
    fun getAll(): List<PlayerEntity>

    @Query("select * from PlayerEntity where id = :id")
    fun findPlayerById(id: String): PlayerEntity

    @Insert(onConflict = REPLACE)
    fun insertPlayer(playerEntity: PlayerEntity)

    @Update(onConflict = REPLACE)
    fun updatePlayer(playerEntity: PlayerEntity)

    @Delete
    fun deletePlayer(playerEntity: PlayerEntity)
}