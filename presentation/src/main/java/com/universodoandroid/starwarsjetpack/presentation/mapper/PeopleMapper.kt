package com.universodoandroid.starwarsjetpack.presentation.mapper

import com.universodoandroid.starwarsjetpack.data.entities.Person
import com.universodoandroid.starwarsjetpack.presentation.dto.PersonDetailsDto
import com.universodoandroid.starwarsjetpack.presentation.dto.PersonDto

internal object PeopleMapper {

    fun entityToDto(entities: List<Person>): List<PersonDto> {
        val viewData = ArrayList<PersonDto>()
        entities.forEach { viewData.add(PersonDto(it.id, it.name, "")) }
        return viewData
    }

    fun entityToDto(personEntity: Person) = PersonDetailsDto(
        id = personEntity.id,
        name = personEntity.name,
        height = personEntity.height
    )

}