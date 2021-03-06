package com.mikrasov.courses.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class StudentCoursePayment(
    @Id
    @GeneratedValue
    var id: Int,
    @ManyToOne
    var student: Student,
    @ManyToOne
    var course: Course,
    /**
     * Amount of lessons that was paid. Updates after student payment
     */
    var paidLessons: Int,
    /**
     * Amount of lessons that student have gotten. Increments after lesson have been marked as finished
     */
    var gottenLessons: Int,
)
