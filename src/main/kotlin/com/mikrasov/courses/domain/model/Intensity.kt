package com.mikrasov.courses.domain.model

/**
 * Preferable amount of classes per week
 */
enum class Intensity(val lessonsPerWeek: Int) {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    companion object {
        private val map = values().associateBy(Intensity::lessonsPerWeek)
        fun fromInt(type: Int) = map[type]
    }
}