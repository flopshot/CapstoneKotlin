package com.seannajera.golfiq.model.persistenceDb.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.model.persistenceDb.entity.MarkerLocation

@Dao
interface MarkerLocationDao {
    @Query("select * from MarkerLocation")
    fun getAll(): List<MarkerLocation>

    @Query("select * from MarkerLocation where id = :id")
    fun findMarkerLocationById(id: Long): MarkerLocation

    @Insert(onConflict = REPLACE)
    fun insertMarkerLocation(markerLocation: MarkerLocation)

    @Update(onConflict = REPLACE)
    fun updateMarkerLocation(markerLocation: MarkerLocation)

    @Delete
    fun deleteMarkerLocation(markerLocation: MarkerLocation)
}