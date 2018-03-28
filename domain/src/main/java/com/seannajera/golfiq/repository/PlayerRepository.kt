package com.seannajera.golfiq.repository

import com.seannajera.golfiq.entities.Player
import io.reactivex.Completable
import io.reactivex.Single

interface PlayerRepository{
    fun getPlayers(): Single<MutableList<Player>>
    fun getPlayerById(id: Int): Single<Player>
    fun deleteById(id: Int): Completable
    fun delete(player: Player): Completable
    fun updatePlayer(player: Player): Completable
    fun createPlayer(player: Player): Completable
}