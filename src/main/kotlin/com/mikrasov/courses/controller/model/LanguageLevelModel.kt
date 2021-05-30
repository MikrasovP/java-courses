package com.mikrasov.courses.controller.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.mikrasov.courses.domain.model.LanguageLevel

data class LanguageLevelModel(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val levelName: String,
    @JsonProperty("code")
    val levelCode: String,
) {
    companion object {
        fun fromEntity(languageLevel: LanguageLevel) = LanguageLevelModel(
            languageLevel.id,
            languageLevel.levelName,
            languageLevel.levelCode,
        )
    }
}
