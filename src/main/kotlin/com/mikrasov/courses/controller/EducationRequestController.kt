package com.mikrasov.courses.controller

import com.mikrasov.courses.controller.model.EducationRequestModel
import com.mikrasov.courses.domain.dao.LanguageDao
import com.mikrasov.courses.domain.dao.LanguageLevelDao
import com.mikrasov.courses.domain.dao.StudentDao
import com.mikrasov.courses.domain.model.Intensity
import com.mikrasov.courses.service.EducationRequestService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/api/education_request")
class EducationRequestController(
    private val studentDao: StudentDao,
    private val languageDao: LanguageDao,
    private val languageLevelDao: LanguageLevelDao,

    private val educationRequestService: EducationRequestService,
) {

    @PostMapping("/apply")
    fun applyForEducation(@RequestBody educationRequestModel: EducationRequestModel): ResponseEntity<String> {
        val student = studentDao.findByIdOrNull(educationRequestModel.studentId)
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Student with such id doesn't exist")
        val language = languageDao.findByIdOrNull(educationRequestModel.languageId)
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Language with such id wasn't found")
        val languageLevel = languageLevelDao.findByIdOrNull(educationRequestModel.languageLevelId)
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Language Level with such id was not found")
        val intensity = Intensity.fromInt(educationRequestModel.intensity)
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Intensity should be from 1 to 7")

        educationRequestService.addNewRequest(student, language, languageLevel, intensity)
        return ResponseEntity.ok().build()
    }

}