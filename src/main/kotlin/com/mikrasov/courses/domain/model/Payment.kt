package com.mikrasov.courses.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Payment(
    @Id
    @GeneratedValue
    var id: Long,
    /**
     * Amount of payed money in cent (100 cents == 1 dollar)
     */
    val amount: Int = 0,
    /**
     * Student, whose education was paid
     */
    @ManyToOne
    val student: Student,
)
