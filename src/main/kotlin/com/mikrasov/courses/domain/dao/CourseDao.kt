package com.mikrasov.courses.domain.dao

import com.mikrasov.courses.domain.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseDao : JpaRepository<Course, Long> {
}