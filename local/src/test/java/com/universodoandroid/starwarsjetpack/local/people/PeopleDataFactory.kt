package com.universodoandroid.starwarsjetpack.local.people

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity

internal object PeopleDataFactory {

    fun dummyPersonEntity() =
        PersonEntity(
            id = "7960f27b-3b4a-4b7c-85cd-6ce7bd47fbfe",
            birthYear = "05/05/1999",
            created = "05/05/2018",
            edited = "05/05/2019",
            eyeColor = "Blue",
            gender = "Man",
            hairColor = "Yellow",
            height = "1.75",
            homeworld = "Earth",
            mass = "55",
            name = "Skywalker",
            skinColor = "White",
            url = "..."
        )

    fun dummyPersonDomain() = Person(
        id = "7960f27b-3b4a-4b7c-85cd-6ce7bd47fbfe",
        birthYear = "05/05/1998",
        created = "05/07/2019",
        edited = "01/08/2019",
        eyeColor = "White",
        gender = "Man",
        hairColor = "Yellow",
        height = "1.77",
        homeworld = "Earth",
        mass = "55",
        name = "Ackbar",
        skinColor = "Black",
        url = "..."
    )

}