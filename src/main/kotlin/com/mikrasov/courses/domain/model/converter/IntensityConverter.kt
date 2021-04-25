package com.mikrasov.courses.domain.model.converter

import com.mikrasov.courses.domain.model.Intensity
import javax.persistence.AttributeConverter

class IntensityConverter : AttributeConverter<Intensity, Int> {

    companion object {
        private const val DEFAULT_IF_NULL = 2
    }

    override fun convertToDatabaseColumn(attribute: Intensity?): Int =
        attribute?.lessonsPerWeek ?: DEFAULT_IF_NULL


    override fun convertToEntityAttribute(dbData: Int?): Intensity =
        Intensity.fromInt(dbData?: DEFAULT_IF_NULL)!!
}