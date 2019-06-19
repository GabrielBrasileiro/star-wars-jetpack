package com.universodoandroid.local.mapper

import com.universodoandroid.domain.people.Person
import com.universodoandroid.local.entity.PersonEntity
import java.util.*

object PersonMapper {

    fun toData(person: Person) = PersonEntity(
        id        = UUID.randomUUID().toString(),
        birthYear = person.birth_year,
        created   = person.created,
        edited    = person.edited,
        eyeColor  = person.eye_color,
        gender    = person.gender,
        hairColor = person.hair_color,
        height    = person.height,
        homeworld = person.homeworld,
        mass      = person.mass,
        name      = person.name,
        skinColor = person.skin_color,
        url       = person.url
    )

    fun fromData(personEntity: PersonEntity) = Person(
        id         = personEntity.id,
        birth_year = personEntity.birthYear,
        created    = personEntity.created,
        edited     = personEntity.edited,
        eye_color  = personEntity.eyeColor,
        gender     = personEntity.gender,
        hair_color = personEntity.hairColor,
        height     = personEntity.height,
        homeworld  = personEntity.homeworld,
        mass       = personEntity.mass,
        name       = personEntity.name,
        skin_color = personEntity.skinColor,
        url        = personEntity.url
    )

}