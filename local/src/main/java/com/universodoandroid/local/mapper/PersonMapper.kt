package com.universodoandroid.local.mapper

import com.universodoandroid.domain.people.Person
import com.universodoandroid.local.entity.PersonEntity

object PersonMapper {

    fun toData(person: Person) = PersonEntity(
        id        = person.id,
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

}