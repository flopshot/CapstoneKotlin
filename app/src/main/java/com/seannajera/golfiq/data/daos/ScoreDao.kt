package com.seannajera.golfiq.data.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.data.entities.ScoreEntity

@Dao
interface ScoreDao {
    @Query("select * from ScoreEntity")
    fun getAll(): List<ScoreEntity>

    @Query("select * from ScoreEntity where id = :id")
    fun findScoreById(id: String): ScoreEntity

    @Insert(onConflict = REPLACE)
    fun insertScore(scoreEntity: ScoreEntity)

    @Update(onConflict = REPLACE)
    fun updateScore(scoreEntity: ScoreEntity)

    @Delete
    fun deleteScore(scoreEntity: ScoreEntity)
}