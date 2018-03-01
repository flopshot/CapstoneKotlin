package com.seannajera.golfiq.data.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.data.entities.PlayerLocationEntity

@Dao
interface UserLocationDao {
    @Query("select * from PlayerLocationEntity")
    fun getAll(): List<PlayerLocationEntity>

    @Query("select * from PlayerLocationEntity where id = :id")
    fun findUserLocationById(id: Long): PlayerLocationEntity

    @Insert(onConflict = REPLACE)
    fun insertUserLocation(playerLocationEntity: PlayerLocationEntity)

    @Update(onConflict = REPLACE)
    fun updateUserLocation(playerLocationEntity: PlayerLocationEntity)

    @Delete
    fun deleteUserLocation(playerLocationEntity: PlayerLocationEntity)
}