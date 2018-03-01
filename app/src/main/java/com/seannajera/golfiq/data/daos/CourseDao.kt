package com.seannajera.golfiq.data.daos

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.data.entities.CourseEntity

@Dao
interface CourseDao {
    @Query("select * from CourseEntity")
    fun getAll(): List<CourseEntity>

    @Query("select * from CourseEntity where id = :id")
    fun findCourseById(id: String): CourseEntity

    @Insert(onConflict = REPLACE)
    fun insertCourse(courseEntity: CourseEntity)

    @Update(onConflict = REPLACE)
    fun updateCourse(courseEntity: CourseEntity)

    @Delete
    fun deleteCourse(courseEntity: CourseEntity)
}