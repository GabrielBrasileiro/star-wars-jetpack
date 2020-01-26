package com.universodoandroid.starwarsjetpack.domain.people.data

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person

object PeopleData {

    fun getPeople() = listOf(
        getPerson("0"),
        getPerson("1")
    )

    fun getPerson(id: String) = Person(
        id = id,
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