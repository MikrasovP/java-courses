package com.mikrasov.courses.domain.dao

import com.mikrasov.courses.domain.model.EducationRequest
import com.mikrasov.courses.domain.model.Language
import com.mikrasov.courses.domain.model.LanguageLevel
import org.springframework.data.jpa.repository.JpaRepository

interface EducationRequestDao : JpaRepository<EducationRequest, Long> {

    fun findAllByHandledFalseAndLanguageAndLanguageLevel(
        language: Language,
        languageLevel: LanguageLevel,
    ): MutableList<EducationRequest>

}