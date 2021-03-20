package com.mikrasov.courses.domain.dao

import com.mikrasov.courses.domain.model.Room
import org.springframework.data.jpa.repository.JpaRepository

interface RoomDao: JpaRepository<Room, Long> {
}
