package com.universodoandroid.starwarsjetpack.local.people.data

import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity
import java.util.*

internal object PeopleEntityDataFactory {

    fun dummyPeopleEntity() = listOf(
        PersonEntity(
            id = UUID.randomUUID().toString(),
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
        ),
        PersonEntity(
            id = UUID.randomUUID().toString(),
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
    )
}