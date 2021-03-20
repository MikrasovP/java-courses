package com.mikrasov.courses.domain.model

import javax.persistence.*

@Entity
data class Teacher(
    @Id
    @GeneratedValue
    var id: Long,
    /**
     * Teacher's surname, is used in lessons schedule
     */
    var surname: String = "",
    var firstAndMiddleName: String = "",
    /**
     * List of languages that teacher is able to teach
     */
    @ManyToMany
    var languages: List<Language> = listOf(),
)
