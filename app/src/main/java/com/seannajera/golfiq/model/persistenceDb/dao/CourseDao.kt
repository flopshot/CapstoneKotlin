package com.seannajera.golfiq.model.persistenceDb.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.model.persistenceDb.entity.Course

@Dao
interface CourseDao {
    @Query("select * from Course")
    fun getAll(): List<Course>

    @Query("select * from Course where id = :id")
    fun findCourseById(id: Long): Course

    @Insert(onConflict = REPLACE)
    fun insertCourse(course: Course)

    @Update(onConflict = REPLACE)
    fun updateCourse(course: Course)

    @Delete
    fun deleteCourse(course: Course)
}