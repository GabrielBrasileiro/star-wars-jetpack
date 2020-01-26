package com.universodoandroid.starwarsjetpack.local.people.mapper

import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.local.people.entity.PersonEntity
import java.util.*

internal object PersonMapper {

    fun toData(person: PersonData) =
        PersonEntity(
            id = UUID.randomUUID().toString(),
            birthYear = person.birthYear,
            created = person.created,
            edited = person.edited,
            eyeColor = person.eyeColor,
            gender = person.gender,
            hairColor = person.hairColor,
            height = person.height,
            homeworld = person.homeworld,
            mass = person.mass,
            name = person.name,
            skinColor = person.skinColor,
            url = person.url
        )

    fun fromData(personEntity: PersonEntity) =
        PersonData(
            id = personEntity.id,
            birthYear = personEntity.birthYear,
            created = personEntity.created,
            edited = personEntity.edited,
            eyeColor = personEntity.eyeColor,
            gender = personEntity.gender,
            hairColor = personEntity.hairColor,
            height = personEntity.height,
            homeworld = personEntity.homeworld,
            mass = personEntity.mass,
            name = personEntity.name,
            skinColor = personEntity.skinColor,
            url = personEntity.url
        )

    fun dataEntitiesToEntities(dataEntities: List<PersonEntity>) = dataEntities.map(::fromData)

    fun entitiesToDataEntities(entities: List<PersonData>) = entities.map(::toData)


}