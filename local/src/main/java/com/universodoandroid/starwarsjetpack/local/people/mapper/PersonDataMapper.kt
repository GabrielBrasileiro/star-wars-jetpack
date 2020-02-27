package com.universodoandroid.starwarsjetpack.local.people.mapper

import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper

internal class PersonDataMapper :
    Mapper<PersonEntity, PersonData> {

    override fun map(enter: PersonEntity): PersonData {
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