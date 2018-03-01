package com.seannajera.golfiq.data.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.data.entities.HoleEntity

@Dao
interface HoleDao {
    @Query("select * from HoleEntity")
    fun getAll(): List<HoleEntity>

    @Query("select * from HoleEntity where id = :id")
    fun findHoleById(id: Long): HoleEntity

    @Insert(onConflict = REPLACE)
    fun insertHoles(holeEntity: HoleEntity)

    @Update(onConflict = REPLACE)
    fun updateHoles(holeEntity: HoleEntity)

    @Delete
    fun deleteHoles(holeEntity: HoleEntity)
}