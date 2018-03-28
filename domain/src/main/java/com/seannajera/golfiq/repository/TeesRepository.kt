package com.seannajera.golfiq.repository

import com.seannajera.golfiq.entities.Tees
import io.reactivex.Completable
import io.reactivex.Single

interface TeesRepository {
    fun getLocations(): Single<MutableList<Tees>>
    fun getLocationById(id: Int): Single<Tees>
    fun deleteById(id: Int): Completable
    fun delete(tees: Tees): Completable
    fun updateLocation(tees: Tees): Completable
    fun createLocation(tees: Tees): Completable
}