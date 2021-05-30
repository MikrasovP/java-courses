package com.mikrasov.courses.controller.student

import com.mikrasov.courses.controller.model.StudentModel
import com.mikrasov.courses.domain.dao.StudentDao
import com.mikrasov.courses.domain.model.Student
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/student")
class StudentController(
    private val studentDao: StudentDao,
) {

    @PostMapping("/create")
    fun addStudent(@RequestBody student: StudentCreateRequestModel): StudentModel {
        if (student.fullName.isNullOrBlank())
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Student name can't be empty or blank")
        val studentEntity = studentDao.save(Student(fullName = student.fullName))
        return StudentModel(studentEntity.id, studentEntity.fullName)
    }

}