package com.seannajera.golfiq.repository

import com.seannajera.golfiq.entities.Club
import io.reactivex.Completable
import io.reactivex.Single

interface ClubRepository {
    fun getClubs(): Single<MutableList<Club>>
    fun getClubById(id: Int): Single<Club>
    fun deleteById(id: Int): Completable
    fun delete(club: Club): Completable
    fun updateClub(club: Club): Completable
    fun createClub(club: Club): Completable
}