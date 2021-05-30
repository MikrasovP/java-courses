package com.mikrasov.courses.controller.student

import com.fasterxml.jackson.annotation.JsonProperty

data class StudentCreateRequestModel(
    @JsonProperty("full_name")
    val fullName: String?,
)
