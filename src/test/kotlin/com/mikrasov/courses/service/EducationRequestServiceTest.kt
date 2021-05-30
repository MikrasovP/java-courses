package com.mikrasov.courses.service

import com.mikrasov.courses.config.EducationRequestConfig
import com.mikrasov.courses.domain.dao.CourseDao
import com.mikrasov.courses.domain.dao.EducationRequestDao
import com.mikrasov.courses.domain.model.*
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
//@Import(EducationRequestServiceTestContextConfiguration::class)
class EducationRequestServiceTest {

    @MockkBean
    private lateinit var educationRequestDao: EducationRequestDao

    @MockkBean
    private lateinit var courseDao: CourseDao

    private val educationRequestConfig = EducationRequestConfig(3)
    private lateinit var educationRequestService: EducationRequestService

    @BeforeEach
    internal fun setUp() {
        educationRequestService = EducationRequestService(educationRequestConfig, educationRequestDao, courseDao)
    }

    @Test
    fun testRequestForm() {
        val student1 = Student(1L, "Test first")
        val student2 = Student(2L, "Test second")
        val student3 = Student(3L, "Test third")
        val language = Language(1L, "Test language")
        val languageLevel = LanguageLevel(1L, "Test language level", "T1")

        val request1 = EducationRequest(1L, student1, language, languageLevel, Intensity.TWO)
        val request2 = EducationRequest(2L, student2, language, languageLevel, Intensity.TWO)
        val request3 = EducationRequest(3L, student3, language, languageLevel, Intensity.TWO)
        val requestsInDb = mutableListOf(request1, request2)

        val course = Course(
            language = language,
            level = languageLevel,
            intensity = Intensity.TWO,
            students = mutableListOf(student1, student2, student3),
        )

        every {
            educationRequestDao.findAllByHandledFalseAndLanguageAndLanguageLevel(any(), any())
        } answers {
            requestsInDb.toMutableList()
        }
        every {
            educationRequestDao.save(any())
        } answers {
            requestsInDb.add(firstArg())
            firstArg()
        }
        every {
            educationRequestDao.saveAll<EducationRequest>(any())
        } answers {
            requestsInDb.addAll(firstArg())
            firstArg()
        }
        every {
            educationRequestDao.deleteAll(any())
        } answers {
            requestsInDb.removeAll(firstArg())
        }
        every {
            courseDao.save(any())
        } answers {
            firstArg()
        }

        educationRequestService.addNewRequest(student3, language, languageLevel, Intensity.TWO)

        verify { courseDao.save(course) }
        assertThat(requestsInDb.count())
            .isEqualTo(3)
        assertThat(requestsInDb.count { it.handled })
            .isEqualTo(3)
    }
}