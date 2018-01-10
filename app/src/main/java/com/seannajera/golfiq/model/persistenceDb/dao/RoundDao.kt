package com.seannajera.golfiq.model.persistenceDb.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.model.persistenceDb.entity.Round

@Dao
interface RoundDao {
//TODO
//    @Query("""
//
//        """)
//    fun getRoundInfos(): List<RoundInfo>
//
//    @Query("""
//
//        """)
//    fun getRoundInfoById(roundId: Long): RoundInfo
//
//    @Query("""
//
//        """)
//    fun getScorecardView(roundId: Long): ScorecardView
//
//    @Query("""
//
//        """)
//    fun getHoleView(roundId: Long): HoleView

    @Query("select * from Round")
    fun getAll(): List<Round>

    @Query("select * from Round where id = :id")
    fun findRoundById(id: Long): Round

    @Insert(onConflict = REPLACE)
    fun insertRound(round: Round)

    @Update(onConflict = REPLACE)
    fun updateRound(round: Round)

    @Delete
    fun deleteRound(round: Round)
}