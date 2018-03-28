package com.seannajera.golfiq.interactors

import io.reactivex.Single

interface SingleUseCaseWithParameter<P, R> {

    fun execute(parameter: P): Single<R>
}