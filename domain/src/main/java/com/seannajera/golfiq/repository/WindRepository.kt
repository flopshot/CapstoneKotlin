package com.seannajera.golfiq.repository

import com.seannajera.golfiq.entities.Wind
import io.reactivex.Completable
import io.reactivex.Single

interface WindRepository {
    fun getLocations(): Single<MutableList<Wind>>
    fun getLocationById(id: Int): Single<Wind>
    fun deleteById(id: Int): Completable
    fun delete(wind: Wind): Completable
    fun updateLocation(wind: Wind): Completable
    fun createLocation(wind: Wind): Completable
}