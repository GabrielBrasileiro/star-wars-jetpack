package com.universodoandroid.presentation.mapper

import com.universodoandroid.domain.people.Person
import com.universodoandroid.presentation.dtos.PersonDto

object PeopleMapper {

    fun entityToDto(entities: List<Person>) : List<PersonDto> {
        val dtos = ArrayList<PersonDto>()
        entities.forEach { dtos.add(PersonDto(it.name, "")) }
        return dtos
    }

}