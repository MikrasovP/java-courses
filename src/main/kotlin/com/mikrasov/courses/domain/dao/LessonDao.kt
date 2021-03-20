package com.mikrasov.courses.domain.dao

import com.mikrasov.courses.domain.model.Lesson
import org.springframework.data.jpa.repository.JpaRepository

interface LessonDao : JpaRepository<Lesson, Long> {
}