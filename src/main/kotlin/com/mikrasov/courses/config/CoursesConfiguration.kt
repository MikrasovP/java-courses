package com.mikrasov.courses.config

import com.mikrasov.courses.domain.dao.LanguageDao
import com.mikrasov.courses.domain.dao.LanguageLevelDao
import com.mikrasov.courses.domain.dao.TeacherDao
import com.mikrasov.courses.domain.model.Language
import com.mikrasov.courses.domain.model.LanguageLevel
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
        languageLevelDao: LanguageLevelDao,
        teacherDao: TeacherDao,
    ) = ApplicationRunner {
        //inflateWithDefaultData(languageDao, languageLevelDao, teacherDao)
    }

    private fun inflateWithDefaultData(
        languageDao: LanguageDao,
        languageLevelDao: LanguageLevelDao,
        teacherDao: TeacherDao
    ) {
        val a1 = LanguageLevel(levelName = "Beginner", levelCode = "A1")
        val a2 = LanguageLevel(levelName = "Pre-Intermediate", levelCode = "A2")
        val b1 = LanguageLevel(levelName = "Intermediate", levelCode = "B1")
        val b2 = LanguageLevel(levelName = "Upper-Intermediate", levelCode = "B2")
        val c1 = LanguageLevel(levelName = "Advanced", levelCode = "C1")
        languageLevelDao.saveAll(listOf(a1, a2, b1, b2, c1))

        val english = Language(name = "English")
        val german = Language(name = "German")
        val spanish = Language(name = "Spanish")
        val russian = Language(name = "Russian")
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
                    surname = "Pavlova",
                    firstAndMiddleName = "Olga Viktorovna",
                    languages = mutableListOf(english, russian),
                ),
                Teacher(
                    surname = "Smith",
                    firstAndMiddleName = "Jane",
                    languages = mutableListOf(english, german),
                ),
                Teacher(
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
