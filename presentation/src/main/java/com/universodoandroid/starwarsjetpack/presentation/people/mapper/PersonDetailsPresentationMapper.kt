package com.universodoandroid.starwarsjetpack.presentation.people.mapper

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDetailsDto
import com.universodoandroid.starwarsjetpack.shared.extensions.Mapper

class PersonDetailsPresentationMapper : Mapper<Person, PersonDetailsDto> {

    override fun map(enter: Person): PersonDetailsDto {
        return  PersonDetailsDto(
            id = enter.id,
            name = enter.name,
            height = enter.height
        )
    }
}