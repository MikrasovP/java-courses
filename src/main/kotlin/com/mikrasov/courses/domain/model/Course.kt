package com.mikrasov.courses.domain.model

import javax.persistence.*

@Entity
data class Course(
    @Id
    @GeneratedValue
    var id: Long,

    @ManyToOne
    var language: Language,

    var intensity: Intensity = Intensity.TWO,

    @ManyToOne
    var level: LanguageLevel,

    @ManyToMany
    var students: List<Student> = listOf(),
)
