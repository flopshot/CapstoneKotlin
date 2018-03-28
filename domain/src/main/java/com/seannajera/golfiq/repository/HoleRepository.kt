package com.seannajera.golfiq.repository

import com.seannajera.golfiq.entities.Hole
import io.reactivex.Completable
import io.reactivex.Single

interface HoleRepository{
    fun getHoles(): Single<MutableList<Hole>>
    fun getHoleById(id: Int): Single<Hole>
    fun deleteById(id: Int): Completable
    fun delete(hole: Hole): Completable
    fun updateHole(hole: Hole): Completable
    fun createHole(hole: Hole): Completable
}