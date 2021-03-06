package com.mikrasov.courses.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Student(
    @Id
    @GeneratedValue
    var id: Int,
    var fullName: String = "",

)
