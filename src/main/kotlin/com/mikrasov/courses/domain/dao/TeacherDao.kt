package com.mikrasov.courses.domain.dao

import com.mikrasov.courses.domain.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherDao : JpaRepository<Teacher, Long> {
}