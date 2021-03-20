package com.mikrasov.courses.domain.dao

import com.mikrasov.courses.domain.model.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentDao : JpaRepository<Student, Long> {
}