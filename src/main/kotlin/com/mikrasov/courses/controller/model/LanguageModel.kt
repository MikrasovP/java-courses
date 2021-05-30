package com.mikrasov.courses.controller.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.mikrasov.courses.domain.model.Language

data class LanguageModel(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val name: String = "",
) {
    companion object {
        fun fromEntity(language: Language) = LanguageModel(
            language.id,
            language.name,
        )
    }
}
