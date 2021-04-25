package com.mikrasov.courses.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class EducationRequest(
    @Id
    @GeneratedValue
    var id: Long,

    @ManyToOne
    var student: Student,

    @ManyToOne
    var language: Language,

    @ManyToOne
    var languageLevel: LanguageLevel,

    var intensity: Intensity,
)
