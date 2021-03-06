package com.mikrasov.courses.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class LanguageLevel(
    @Id
    @GeneratedValue
    var id: Int,
    /**
     * For example, Upper-Intermediate
     */
    var levelName: String = "",
    /**
     * For example, B2
     */
    var levelCode: String = "",
)