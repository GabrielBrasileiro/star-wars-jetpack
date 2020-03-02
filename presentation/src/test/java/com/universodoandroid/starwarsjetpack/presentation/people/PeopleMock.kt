package com.universodoandroid.starwarsjetpack.presentation.people

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person

object PeopleMock {

    fun withTwoPeople() = listOf(
        buildPerson("0", "Anakin"),
        buildPerson("1", "Darth")
    )

    private fun buildPerson(id: String, name: String): Person {
        return Person(
            id = id,
            birthYear = "",
            created = "",
            eyeColor = "",
            edited = "",
            films = listOf(),
            gender = "",
            hairColor = "",
            height = "",
            homeworld = "",
            mass = "",
            name = name,
            skinColor = "",
            species = listOf(),
            starships = listOf(),
            url = "",
            vehicles = listOf()
        )
    }

}