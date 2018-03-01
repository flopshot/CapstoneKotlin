package com.seannajera.golfiq.data.daos

import android.arch.persistence.room.*
import com.seannajera.golfiq.data.entities.TeesEntity

@Dao
interface TeesDao {
    @Query("select * from TeesEntity")
    fun getAll(): List<TeesEntity>

    @Query("select * from TeesEntity where id = :id")
    fun findTeeById(id: String): TeesEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTee(teesEntity: TeesEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTees(teesEntity: TeesEntity)

    @Delete
    fun deleteTees(teesEntity: TeesEntity)
}