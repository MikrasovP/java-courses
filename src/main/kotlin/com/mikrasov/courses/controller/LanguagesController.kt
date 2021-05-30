package com.mikrasov.courses.controller

import com.mikrasov.courses.controller.model.LanguageModel
import com.mikrasov.courses.domain.dao.LanguageDao
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/languages")
class LanguagesController(
    private val languageDao: LanguageDao,
) {

    @GetMapping("/all")
    fun getAllLanguages(): List<LanguageModel> {
        return languageDao.findAll().map {
            LanguageModel.fromEntity(it)
        }
    }
}
