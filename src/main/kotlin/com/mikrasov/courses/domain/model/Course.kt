package com.mikrasov.courses.domain.model

import javax.persistence.*

@Entity
data class Course(
    @Id
    @GeneratedValue
    var id: Int,
    @ManyToOne
    var language: Language,
    /**
     * Preferable amount of classes per week
     */
    var intensity: Int,
    @ManyToOne
    var level: LanguageLevel,

    )
