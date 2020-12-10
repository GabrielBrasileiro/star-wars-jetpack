package com.universodoandroid.starwarsjetpack.main.utils

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person

object DataFactory {

    fun create(name: String) = Person(
        id = "",
        birthYear = "",
        created = "",
        edited = "",
        eyeColor = "",
        gender = "",
        hairColor = "",
        height = "",
        homeworld = "",
        mass = "",
        name = name,
        skinColor = "",
        url = ""
    )
}