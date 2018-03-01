package com.seannajera.golfiq.data.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.data.entities.ClubEntity

@Dao
interface ClubDao{
    @Query("select * from ClubEntity")
    fun getAll(): List<ClubEntity>

    @Query("select * from ClubEntity where id = :id")
    fun findClubById(id: String): ClubEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertClub(clubEntity: ClubEntity)

    @Update(onConflict = REPLACE)
    fun updateClub(clubEntity: ClubEntity)

    @Delete
    fun deleteClub(clubEntity: ClubEntity)
}