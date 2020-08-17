package com.universodoandroid.starwarsjetpack.presentation.people.data

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation

object PeopleMock {

    fun withTwoPeople() = listOf(
        buildPerson(
            "0",
            "Anakin"
        ),
        buildPerson(
            "1",
            "Darth"
        )
    )

    fun presentationWithTwoPeople() = listOf(
        PersonPresentation("0", "Anakin", "", ""),
        PersonPresentation("1", "Darth", "", "")
    )

    fun buildPerson(id: String, name: String): Person {
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