package com.seannajera.golfiq.interactors

import io.reactivex.Observable

interface UseCase<T> {

    fun execute(): Observable<T>
}