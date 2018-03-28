package com.seannajera.golfiq.interactors

import io.reactivex.Completable

interface CompletableUseCaseWithParameter<P> {

    fun execute(parameter: P): Completable
}