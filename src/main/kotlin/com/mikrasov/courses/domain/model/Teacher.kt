package com.mikrasov.courses.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Teacher(
    @Id
    @GeneratedValue
    var id: Long = 0,

    /**
     * Teacher's surname, is used in lessons schedule
     */
    var surname: String = "",

    var firstAndMiddleName: String = "",

    /**
     * List of languages that teacher is able to teach
     */
    @ManyToMany
    var languages: MutableList<Language> = mutableListOf(),
)
