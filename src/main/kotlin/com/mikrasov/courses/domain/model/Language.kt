package com.mikrasov.courses.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Language(
    @Id
    @GeneratedValue
    var id: Long,

    var name: String = "",
)