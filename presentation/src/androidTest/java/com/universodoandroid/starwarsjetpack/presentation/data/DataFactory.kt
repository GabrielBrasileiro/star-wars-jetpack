package com.universodoandroid.starwarsjetpack.presentation.data

import com.universodoandroid.starwarsjetpack.domain.entities.Person
import java.util.*
import kotlin.collections.ArrayList

object DataFactory {

    fun dummyPeopleList() = listOf(
        Person(
            id = UUID.randomUUID().toString(),
            birthYear = "",
            created = "",
            edited = "",
            eyeColor = "",
            films = ArrayList(),
            gender = "",
            hairColor = "",
            height = "",
            homeworld = "",
            mass = "",
            name = "",
            skinColor = "",
            species = ArrayList(),
            starships = ArrayList(),
            url = "",
            vehicles = ArrayList()
        ),
        Person(
            id = UUID.randomUUID().toString(),
            birthYear = "",
            created = "",
            edited = "",
            eyeColor = "",
            films = ArrayList(),
            gender = "",
            hairColor = "",
            height = "",
            homeworld = "",
            mass = "",
            name = "",
            skinColor = "",
            species = ArrayList(),
            starships = ArrayList(),
            url = "",
            vehicles = ArrayList()
        )
    )

    fun dummyPerson() = Person(
        id = UUID.randomUUID().toString(),
        birthYear = "",
        created = "",
        edited = "",
        eyeColor = "",
        films = ArrayList(),
        gender = "",
        hairColor = "",
        height = "",
        homeworld = "",
        mass = "",
        name = "",
        skinColor = "",
        species = ArrayList(),
        starships = ArrayList(),
        url = "",
        vehicles = ArrayList()
    )

}