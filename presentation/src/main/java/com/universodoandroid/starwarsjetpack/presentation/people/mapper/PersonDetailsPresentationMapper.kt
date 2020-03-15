package com.universodoandroid.starwarsjetpack.presentation.people.mapper

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDetailsPresentation
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper

internal class PersonDetailsPresentationMapper : Mapper<Person, PersonDetailsPresentation> {

    override fun map(enter: Person): PersonDetailsPresentation {
        return  PersonDetailsPresentation(
            id = enter.id,
            name = enter.name,
            height = enter.height
        )
    }
}