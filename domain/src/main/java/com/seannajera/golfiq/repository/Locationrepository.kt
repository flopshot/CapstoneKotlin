package com.seannajera.golfiq.repository

import com.seannajera.golfiq.entities.Location
import io.reactivex.Completable
import io.reactivex.Single

interface Locationrepository{
    fun getLocations(): Single<MutableList<Location>>
    fun getLocationById(id: Int): Single<Location>
    fun deleteById(id: Int): Completable
    fun delete(location: Location): Completable
    fun updateLocation(location: Location): Completable
    fun createLocation(location: Location): Completable
}