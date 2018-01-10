package com.seannajera.golfiq.model.persistenceDb.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.model.persistenceDb.entity.RoundPlayerHoles

@Dao
interface RoundPlayerHolesDao {
    @Query("select * from RoundPlayerHoles")
    fun getAll(): List<RoundPlayerHoles>

    @Query("select * from RoundPlayerHoles where id = :id")
    fun findRoundPlayerHolesById(id: Long): RoundPlayerHoles

    @Insert(onConflict = REPLACE)
    fun insertRoundPlayerHoles(roundPlayerHoles: RoundPlayerHoles)

    @Update(onConflict = REPLACE)
    fun updateRoundPlayerHoles(roundPlayerHoles: RoundPlayerHoles)

    @Delete
    fun deleteRoundPlayerHoles(roundPlayerHoles: RoundPlayerHoles)
}