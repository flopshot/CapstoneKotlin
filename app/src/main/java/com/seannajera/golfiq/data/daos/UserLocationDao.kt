package com.seannajera.golfiq.data.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.data.entities.UserLocation

@Dao
interface UserLocationDao {
    @Query("select * from UserLocation")
    fun getAll(): List<UserLocation>

    @Query("select * from UserLocation where id = :id")
    fun findUserLocationById(id: Long): UserLocation

    @Insert(onConflict = REPLACE)
    fun insertUserLocation(userLocation: UserLocation)

    @Update(onConflict = REPLACE)
    fun updateUserLocation(userLocation: UserLocation)

    @Delete
    fun deleteUserLocation(userLocation: UserLocation)
}