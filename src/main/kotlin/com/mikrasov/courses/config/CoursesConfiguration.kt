package com.mikrasov.courses.config

import com.mikrasov.courses.domain.dao.LanguageDao
import com.mikrasov.courses.domain.dao.TeacherDao
import com.mikrasov.courses.domain.model.Language
import com.mikrasov.courses.domain.model.Teacher
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.actuate.trace.http.HttpTraceRepository
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CoursesConfiguration {

    @Bean
    fun databaseInitializer(
        languageDao: LanguageDao,
        teacherDao: TeacherDao,
    ) = ApplicationRunner {
        val english = Language(1L, name = "English")
        val german = Language(2L, name = "German")
        val spanish = Language(3L, name = "Spanish")
        val russian = Language(4L, name = "Russian")
        languageDao.saveAll(
            listOf(
                english,
                german,
                spanish,
                russian,
            )
        )

        teacherDao.saveAll(
            listOf(
                Teacher(
                    1L,
                    surname = "Pavlova",
                    firstAndMiddleName = "Olga Viktorovna",
                    languages = mutableListOf(english, russian),
                ),
                Teacher(
                    2L,
                    surname = "Smith",
                    firstAndMiddleName = "Jane",
                    languages = mutableListOf(english, german),
                ),
                Teacher(
                    3L,
                    surname = "Eskobar",
                    firstAndMiddleName = "Pablo",
                    languages = mutableListOf(spanish),
                ),
            )
        )

    }

    @Bean
    fun httpTraceRepository(): HttpTraceRepository = InMemoryHttpTraceRepository()

}
