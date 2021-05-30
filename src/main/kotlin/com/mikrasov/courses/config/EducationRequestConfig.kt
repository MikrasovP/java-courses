package com.mikrasov.courses.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("education.request.handler")
data class EducationRequestConfig(
    val minGroupSize: Int,
)
