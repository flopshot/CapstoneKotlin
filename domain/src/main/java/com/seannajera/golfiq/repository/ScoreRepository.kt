package com.seannajera.golfiq.repository

import com.seannajera.golfiq.entities.Score
import io.reactivex.Completable
import io.reactivex.Single

interface ScoreRepository {
    fun getScores(): Single<MutableList<Score>>
    fun getScoreById(id: Int): Single<Score>
    fun deleteById(id: Int): Completable
    fun delete(score: Score): Completable
    fun updateScore(score: Score): Completable
    fun createScore(score: Score): Completable
}