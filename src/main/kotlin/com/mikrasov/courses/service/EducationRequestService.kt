package com.mikrasov.courses.service

import com.mikrasov.courses.config.EducationRequestConfig
import com.mikrasov.courses.domain.dao.CourseDao
import com.mikrasov.courses.domain.dao.EducationRequestDao
import com.mikrasov.courses.domain.model.*
import org.springframework.stereotype.Service

@Service
class EducationRequestService(
    private val educationRequestConfig: EducationRequestConfig,

    private val educationRequestDao: EducationRequestDao,
    private val courseDao: CourseDao,
) {

    fun addNewRequest(
        student: Student,
        language: Language,
        languageLevel: LanguageLevel,
        intensity: Intensity,
    ) {
        val educationRequest = EducationRequest(
            student = student,
            language = language,
            languageLevel = languageLevel,
            intensity = intensity,
        )
        educationRequestDao.save(educationRequest)

        val sameRequests = educationRequestDao.findAllByHandledFalseAndLanguageAndLanguageLevel(language, languageLevel)
        if (sameRequests.size >= educationRequestConfig.minGroupSize)
            formGroup(sameRequests)
    }

    private fun formGroup(educationRequests: List<EducationRequest>) {
        val students = educationRequests.map { it.student }
        val language = educationRequests.first().language
        val languageLevel = educationRequests.first().languageLevel
        val intensity = educationRequests.first().intensity
        val course = Course(
            language = language,
            level = languageLevel,
            intensity = intensity,
            students = students.toMutableList()
        )
        courseDao.save(course)
    }

}