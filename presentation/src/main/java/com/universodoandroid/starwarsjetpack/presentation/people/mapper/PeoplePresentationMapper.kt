package com.universodoandroid.starwarsjetpack.presentation.people.mapper

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper

internal class PeoplePresentationMapper :
    Mapper<Person, PersonPresentation> {

    override fun map(enter: Person): PersonPresentation {
        return PersonPresentation(
            id = enter.id,
            name = enter.name,
            planet = "",
            imageUrl = enter.imgUrl
        )
    }
}