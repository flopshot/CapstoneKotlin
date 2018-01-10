package com.seannajera.golfiq.model.persistenceDb.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.seannajera.golfiq.model.persistenceDb.entity.CourseHoles

@Dao
interface CourseHolesDao {
@Query("select * from CourseHoles")
fun getAll(): List<CourseHoles>

@Query("select * from CourseHoles where id = :id")
fun findCourseHolesById(id: Long): CourseHoles

@Insert(onConflict = IGNORE)
fun insertCourseHoles(courseHoles: CourseHoles)

@Update(onConflict = REPLACE)
fun updateCourseHoles(courseHoles: CourseHoles)

@Delete
fun deleteCourseHoles(courseHoles: CourseHoles)
}