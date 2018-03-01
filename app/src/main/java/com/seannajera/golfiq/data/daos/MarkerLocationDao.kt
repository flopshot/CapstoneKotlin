package com.seannajera.golfiq.data.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.data.entities.MarkerEntity

@Dao
interface MarkerLocationDao {
    @Query("select * from MarkerEntity")
    fun getAll(): List<MarkerEntity>

    @Query("select * from MarkerEntity where id = :id")
    fun findMarkerLocationById(id: Long): MarkerEntity

    @Insert(onConflict = REPLACE)
    fun insertMarkerLocation(markerEntity: MarkerEntity)

    @Update(onConflict = REPLACE)
    fun updateMarkerLocation(markerEntity: MarkerEntity)

    @Delete
    fun deleteMarkerLocation(markerEntity: MarkerEntity)
}