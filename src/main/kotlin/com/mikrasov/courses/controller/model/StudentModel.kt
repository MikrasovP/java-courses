package com.mikrasov.courses.controller.model

import com.fasterxml.jackson.annotation.JsonProperty

data class StudentModel(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val name: String,
)
