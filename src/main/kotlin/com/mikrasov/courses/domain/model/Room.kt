package com.mikrasov.courses.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Room(
    @Id
    @GeneratedValue
    var id: Long,
    /**
     * Number of room, for example 303, 40B
     */
    var name: String = "",
    /**
     * Amount of students that room is able to contain. Teachers don't counted
     */
    var capacity: Int = 0,
)
