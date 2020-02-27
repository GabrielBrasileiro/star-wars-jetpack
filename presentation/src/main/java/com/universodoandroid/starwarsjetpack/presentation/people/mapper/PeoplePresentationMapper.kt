package com.universodoandroid.starwarsjetpack.presentation.people.mapper

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDto
import com.universodoandroid.starwarsjetpack.shared.extensions.Mapper

class PeoplePresentationMapper : Mapper<Person, PersonDto> {

    override fun map(enter: Person): PersonDto {
        return PersonDto(enter.id, enter.name, "")
    }
}