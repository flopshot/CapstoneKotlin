package com.seannajera.golfiq.model.persistenceDb.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.model.persistenceDb.entity.RoundPlayerCourseHoles

@Dao
interface RoundPlayerCourseHolesDao {
    @Query("select * from RoundPlayerCourseHoles")
    fun getAll(): List<RoundPlayerCourseHoles>

    @Query("select * from RoundPlayerCourseHoles where id = :id")
    fun findRoundPlayerCourseHolesById(id: Long): RoundPlayerCourseHoles

    @Insert(onConflict = REPLACE)
    fun insertRoundPlayerCourseHoles(roundPlayerCourseHoles: RoundPlayerCourseHoles)

    @Update(onConflict = REPLACE)
    fun updateRoundPlayerCourseHoles(roundPlayerCourseHoles: RoundPlayerCourseHoles)

    @Delete
    fun deleteRoundPlayerCourseHoles(roundPlayerCourseHoles: RoundPlayerCourseHoles)
}