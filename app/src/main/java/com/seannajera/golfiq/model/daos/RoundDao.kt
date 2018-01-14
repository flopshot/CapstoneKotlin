package com.seannajera.golfiq.model.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.model.entities.Round
import com.seannajera.golfiq.model.valueObjects.HoleView
import com.seannajera.golfiq.model.valueObjects.RoundInfo
import com.seannajera.golfiq.model.valueObjects.ScorecardView

@Dao
interface RoundDao {
    @Query("""
        SELECT r.id AS roundId, r.createdAt AS startDate, c.id AS courseId, c.courseName AS courseName, c.clubName AS clubName,
            p1.id AS player1Id, p1.firstName AS player1FirstName, p1.lastName AS player1LastName,
            p2.id AS player2Id, p2.firstName AS player2FirstName, p2.lastName AS player2LastName,
            p3.id AS player3Id, p3.firstName AS player3FirstName, p3.lastName AS player3LastName,
            p4.id AS player4Id, p4.firstName AS player4FirstName, p4.lastName AS player4LastName

        FROM Round as r LEFT JOIN Course AS c ON c.id = r.courseId
        LEFT JOIN RoundPlayers AS rp1 ON r.id = rp1.roundId AND rp1.playerOrder = 1
            LEFT JOIN Player AS p1 ON p1.id = rp1.playerId AND rp1.playerOrder = 1
        LEFT JOIN RoundPlayers AS rp2 ON r.id = rp2.roundId AND rp2.playerOrder = 2
            LEFT JOIN Player AS p2 ON p2.id = rp2.playerId AND rp2.playerOrder = 2    
        LEFT JOIN RoundPlayers AS rp3 ON r.id = rp3.roundId AND rp3.playerOrder = 3
            LEFT JOIN Player AS p3 ON p3.id = rp3.playerId AND rp3.playerOrder = 3    
        LEFT JOIN RoundPlayers AS rp4 ON r.id = rp4.roundId AND rp4.playerOrder = 4
            LEFT JOIN Player AS p4 ON p4.id = rp4.playerId AND rp4.playerOrder = 4
        """)
    fun getRoundInfos(): List<RoundInfo>

    @Query("""
        SELECT r.id AS roundId, r.createdAt AS startDate, c.id AS courseId, c.courseName AS courseName, c.clubName AS clubName,
            p1.id AS player1Id, p1.firstName AS player1FirstName, p1.lastName AS player1LastName,
            p2.id AS player2Id, p2.firstName AS player2FirstName, p2.lastName AS player2LastName,
            p3.id AS player3Id, p3.firstName AS player3FirstName, p3.lastName AS player3LastName,
            p4.id AS player4Id, p4.firstName AS player4FirstName, p4.lastName AS player4LastName

        FROM Round as r LEFT JOIN Course AS c ON c.id = r.courseId
        LEFT JOIN RoundPlayers AS rp1 ON r.id = rp1.roundId AND rp1.playerOrder = 1
            LEFT JOIN Player AS p1 ON p1.id = rp1.playerId AND rp1.playerOrder = 1
        LEFT JOIN RoundPlayers AS rp2 ON r.id = rp2.roundId AND rp2.playerOrder = 2
            LEFT JOIN Player AS p2 ON p2.id = rp2.playerId AND rp2.playerOrder = 2
        LEFT JOIN RoundPlayers AS rp3 ON r.id = rp3.roundId AND rp3.playerOrder = 3
            LEFT JOIN Player AS p3 ON p3.id = rp3.playerId AND rp3.playerOrder = 3
        LEFT JOIN RoundPlayers AS rp4 ON r.id = rp4.roundId AND rp4.playerOrder = 4
            LEFT JOIN Player AS p4 ON p4.id = rp4.playerId AND rp4.playerOrder = 4
        WHERE r.id = :roundId
        """)
    fun getRoundInfoById(roundId: Long): RoundInfo

    @Query(            "SELECT r.id AS roundId" +
            ",ch.holeNumber" +
            ",ch.holePar" +
            ",rph1.score AS p1Score" +
            ",rph2.score AS p2Score" +
            ",rph3.score AS p3Score" +
            ",rph4.score AS p4Score" +
            ",substr(p1.firstName,1,1) || substr(p1.lastName,1,1) AS p1Initials" +
            ",substr(p2.firstName,1,1) || substr(p2.lastName,1,1) AS p2Initials" +
            ",substr(p3.firstName,1,1) || substr(p3.lastName,1,1) AS p3Initials" +
            ",substr(p4.firstName,1,1) || substr(p4.lastName,1,1) AS p4Initials" +
            ",rt1.p1Total" +
            ",rt2.p2Total" +
            ",rt3.p3Total" +
            ",rt4.p4Total " +
            "FROM Round AS r " +
            "LEFT JOIN CourseHoles AS ch " +
            "ON ch.courseId = r.courseId " +

            "LEFT JOIN RoundPlayers AS rp1 ON r.id = rp1.roundId AND rp1.playerOrder = 1 " +
            "LEFT JOIN Player AS p1 ON rp1.playerId = p1.id " +
            "LEFT JOIN RoundPlayers AS rp2 ON r.id = rp2.roundId AND rp2.playerOrder = 2 " +
            "LEFT JOIN Player AS p2 ON rp2.playerId = p2.id " +
            "LEFT JOIN RoundPlayers AS rp3 ON r.id = rp3.roundId AND rp3.playerOrder = 3 " +
            "LEFT JOIN Player AS p3 ON rp3.playerId = p3.id " +
            "LEFT JOIN RoundPlayers AS rp4 ON r.id = rp4.roundId AND rp4.playerOrder = 4 " +
            "LEFT JOIN Player AS p4 ON rp4.playerId = p4.id " +

            "LEFT JOIN RoundPlayerHoles AS rph1 " +
            "ON rph1.roundPlayerId = rp1.id " +
            "AND ch.holeNumber = rph1.holeNumber " +
            "LEFT JOIN RoundPlayerHoles AS rph2 " +
            "ON rph2.roundPlayerId = rp2.id " +
            "AND ch.holeNumber = rph2.holeNumber " +
            "LEFT JOIN RoundPlayerHoles AS rph3 " +
            "ON rph3.roundPlayerId = rp3.id " +
            "AND ch.holeNumber = rph3.holeNumber " +
            "LEFT JOIN RoundPlayerHoles AS rph4 " +
            "ON rph4.roundPlayerId = rp4.id " +
            "AND ch.holeNumber = rph4.holeNumber " +

            "LEFT JOIN ( " +
            "SELECT roundId ,SUM(score) AS p1Total " +
            "FROM RoundPlayerHoles " +
            "WHERE substr(roundPlayerId, -1) = '1' " +
            "GROUP BY roundPlayerId " +
            ") AS rt1 ON rt1.roundId = r.id " +
            "LEFT JOIN ( " +
            "SELECT roundId ,SUM(score) AS p2Total " +
            "FROM RoundPlayerHoles " +
            "WHERE substr(roundPlayerId, -1) = '2' " +
            "GROUP BY roundPlayerId " +
            ") AS rt2 ON rt2.roundId = r.id " +
            "LEFT JOIN ( " +
            "SELECT roundId ,SUM(score) AS p3Total " +
            "FROM RoundPlayerHoles " +
            "WHERE substr(roundPlayerId, -1) = '3' " +
            "GROUP BY roundPlayerId " +
            ") AS rt3 ON rt3.roundId = r.id " +
            "LEFT JOIN ( " +
            "SELECT roundId ,SUM(score) AS p4Total " +
            "FROM RoundPlayerHoles " +
            "WHERE substr(roundPlayerId, -1) = '4' " +
            "GROUP BY roundPlayerId " +
            ") AS rt4 ON rt4.roundId = r.id " +
            " WHERE r.id = :roundId")
    fun getScorecardView(roundId: Long): ScorecardView

    @Query("SELECT " +
                    "r.id AS roundId" +
                    ",ch.holeNumber" +
                    ",ch.holeDistance" +
                    ",ch.holePar" +
                    ",rph1.score AS p1Score" +
                    ",rph2.score AS p2Score" +
                    ",rph3.score AS p3Score" +
                    ",rph4.score AS p4Score" +
                    ",rph1.putts AS p1Putts" +
                    ",rph2.putts AS p2Putts" +
                    ",rph3.putts AS p3Putts" +
                    ",rph4.putts AS p4Putts" +
                    ",rph1.penalties AS p1Penalties" +
                    ",rph2.penalties AS p2Penalties" +
                    ",rph3.penalties AS p3Penalties" +
                    ",rph4.penalties AS p4Penalties" +
                    ",rph1.sandShots AS p1Sand" +
                    ",rph2.sandShots AS p2Sand" +
                    ",rph3.sandShots AS p3Sand" +
                    ",rph4.sandShots AS p4Sand" +
                    ",rph1.girFlag AS p1Gir" +
                    ",rph2.girFlag AS p2Gir" +
                    ",rph3.girFlag AS p3Gir" +
                    ",rph4.girFlag AS p4Gir" +
                    ",rph1.firFlag AS p1Fir" +
                    ",rph2.firFlag AS p2Fir" +
                    ",rph3.firFlag AS p3Fir" +
                    ",rph4.firFlag AS p4Fir" +
                    ",substr(p1.firstName,1,1) || substr(p1.lastName,1,1) AS p1Initials" +
                    ",substr(p2.firstName,1,1) || substr(p2.lastName,1,1) AS p2Initials" +
                    ",substr(p3.firstName,1,1) || substr(p3.lastName,1,1) AS p3Initials" +
                    ",substr(p4.firstName,1,1) || substr(p4.lastName,1,1) AS p4Initials" +
                    ",hc.holeCount " +

                    "FROM Round AS r " +
                    "LEFT JOIN CourseHoles AS ch " +
                    "ON ch.courseId = r.courseId " +

                    "LEFT JOIN RoundPlayers AS rp1 ON r.id = rp1.roundId AND rp1.playerOrder = 1 " +
                    "LEFT JOIN Player AS p1 ON rp1.playerId = p1.id " +
                    "LEFT JOIN RoundPlayers AS rp2 ON r.id = rp2.roundId AND rp2.playerOrder = 2 " +
                    "LEFT JOIN Player AS p2 ON rp2.playerId = p2.id " +
                    "LEFT JOIN RoundPlayers AS rp3 ON r.id = rp3.roundId AND rp3.playerOrder = 3 " +
                    "LEFT JOIN Player AS p3 ON rp3.playerId = p3.id " +
                    "LEFT JOIN RoundPlayers AS rp4 ON r.id = rp4.roundId AND rp4.playerOrder = 4 " +
                    "LEFT JOIN Player AS p4 ON rp4.playerId = p4.id " +

                    "LEFT JOIN RoundPlayerHoles AS rph1 " +
                    "ON rph1.roundPlayerId = rp1.id " +
                    "AND ch.holeNumber = rph1.holeNumber " +
                    "LEFT JOIN RoundPlayerHoles AS rph2 " +
                    "ON rph2.roundPlayerId = rp2.id " +
                    "AND ch.holeNumber = rph2.holeNumber " +
                    "LEFT JOIN RoundPlayerHoles AS rph3 " +
                    "ON rph3.roundPlayerId = rp3.id " +
                    "AND ch.holeNumber = rph3.holeNumber " +
                    "LEFT JOIN RoundPlayerHoles AS rph4 " +
                    "ON rph4.roundPlayerId = rp4.id " +
                    "AND ch.holeNumber = rph4.holeNumber " +
                    "LEFT JOIN ( " +
                    "    SELECT courseId, COUNT(DISTINCT holeNumber) AS holeCount" +
                    "    FROM CourseHoles GROUP BY courseId" +
                    ") AS hc ON hc.courseId = r.courseId " +
                    " WHERE r.id = :roundId AND ch.holeNumber = :holeNumber"
        )
    fun getHoleView(roundId: Long, holeNumber: Int): HoleView

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