package com.mikrasov.courses.domain.dao

import com.mikrasov.courses.domain.model.StudentCoursePayment
import org.springframework.data.jpa.repository.JpaRepository

interface StudentCoursePaymentDao : JpaRepository<StudentCoursePayment, Long> {
}
