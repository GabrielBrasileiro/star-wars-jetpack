package com.universodoandroid.presentation.mapper

import com.universodoandroid.domain.people.Person
import com.universodoandroid.presentation.dto.PersonDto
import java.util.*
import kotlin.collections.ArrayList

object PeopleMapper {

    fun entityToDto(entities: List<Person>) : List<PersonDto> {
        val dtos = ArrayList<PersonDto>()
        entities.forEach { dtos.add(PersonDto(UUID.randomUUID().toString(), it.name, "")) }
        return dtos
    }

}