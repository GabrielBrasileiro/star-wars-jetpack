package com.universodoandroid.presentation.mapper

import com.universodoandroid.domain.people.Person
import com.universodoandroid.presentation.dto.PersonDetailsDto
import com.universodoandroid.presentation.dto.PersonDto
import java.util.*
import kotlin.collections.ArrayList

object PeopleMapper {

    fun entityToDto(entities: List<Person>) : List<PersonDto> {
        val viewData = ArrayList<PersonDto>()
        entities.forEach { viewData.add(PersonDto(it.id, it.name, "")) }
        return viewData
    }

    fun entityToDto(personEntity: Person) = PersonDetailsDto(
        id     = personEntity.id,
        name   = personEntity.name,
        height = personEntity.height
    )

}