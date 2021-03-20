package com.mikrasov.courses.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Lesson(
    @Id
    @GeneratedValue
    var id: Long,
    var plannedStartTime: Long = 0L,
    @ManyToOne
    var course: Course,
)
