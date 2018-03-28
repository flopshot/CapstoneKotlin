package com.seannajera.golfiq.interactors

import io.reactivex.Completable

interface CompletableUseCase {

    fun execute(): Completable
}