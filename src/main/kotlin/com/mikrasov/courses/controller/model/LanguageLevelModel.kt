package com.mikrasov.courses.controller.model

import com.fasterxml.jackson.annotation.JsonProperty

data class LanguageLevelModel(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val levelName: String,
    @JsonProperty("code")
    val levelCode: String,
)
