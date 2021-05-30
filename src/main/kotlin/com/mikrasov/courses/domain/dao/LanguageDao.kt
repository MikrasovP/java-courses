package com.mikrasov.courses.domain.dao

import com.mikrasov.courses.domain.model.Language
import org.springframework.data.jpa.repository.JpaRepository

interface LanguageDao : JpaRepository<Language, Long> {

}