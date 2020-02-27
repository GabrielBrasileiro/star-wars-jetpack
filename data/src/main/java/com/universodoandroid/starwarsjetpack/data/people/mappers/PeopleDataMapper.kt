package com.universodoandroid.starwarsjetpack.data.people.mappers

import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper

internal class PeopleDataMapper :
    Mapper<Person, PersonData> {

    override fun map(enter: Person): PersonData {
        return PersonData(
            id = enter.id,
            birthYear = enter.birthYear,
            created = enter.created,
            edited = enter.edited,
            eyeColor = enter.eyeColor,
            gender = enter.gender,
            hairColor = enter.hairColor,
            height = enter.height,
            homeworld = enter.homeworld,
            mass = enter.mass,
            name = enter.name,
            skinColor = enter.skinColor,
            url = enter.url
        )
    }
}