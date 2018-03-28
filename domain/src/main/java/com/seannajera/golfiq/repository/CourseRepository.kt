package com.seannajera.golfiq.repository

import com.seannajera.golfiq.entities.Course
import io.reactivex.Completable
import io.reactivex.Single

interface CourseRepository{
    fun getCourses(): Single<MutableList<Course>>
    fun getCourseById(id: Int): Single<Course>
    fun deleteById(id: Int): Completable
    fun delete(course: Course): Completable
    fun updateCourse(course: Course): Completable
    fun createCourse(course: Course): Completable
}