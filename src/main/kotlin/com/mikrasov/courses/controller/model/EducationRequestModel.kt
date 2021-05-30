package com.mikrasov.courses.controller.model

import com.fasterxml.jackson.annotation.JsonProperty

data class EducationRequestModel(
    @JsonProperty("student_id")
    val studentId: Long,
    @JsonProperty("language_id")
    var languageId: Long,
    @JsonProperty("language_level")
    val languageLevelId: Long,
    /**
     * amount of lessons per week
     */
    @JsonProperty("intensity")
    val intensity: Int,
)
