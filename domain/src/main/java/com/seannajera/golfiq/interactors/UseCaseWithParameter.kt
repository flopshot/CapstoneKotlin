package com.seannajera.golfiq.interactors

import io.reactivex.Observable

interface UseCaseWithParameter<P, R> {

    fun execute(parameter: P): Observable<R>
}