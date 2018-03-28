package com.seannajera.golfiq.repository

import com.seannajera.golfiq.entities.Round
import io.reactivex.Completable
import io.reactivex.Single

interface RoundRepository{
    fun getRounds(): Single<MutableList<Round>>
    fun getRoundById(id: Int): Single<Round>
    fun deleteById(id: Int): Completable
    fun delete(round: Round): Completable
    fun updateRound(round: Round): Completable
    fun createRound(round: Round): Completable
}