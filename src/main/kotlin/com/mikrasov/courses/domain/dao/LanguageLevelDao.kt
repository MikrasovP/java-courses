package com.mikrasov.courses.domain.dao

import com.mikrasov.courses.domain.model.LanguageLevel
import org.springframework.data.jpa.repository.JpaRepository

interface LanguageLevelDao : JpaRepository<LanguageLevel, Long> {
}