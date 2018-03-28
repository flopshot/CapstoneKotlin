package com.seannajera.golfiq.interactors

import io.reactivex.Single

interface SingleUseCase<T> {

    fun execute(): Single<T>
}