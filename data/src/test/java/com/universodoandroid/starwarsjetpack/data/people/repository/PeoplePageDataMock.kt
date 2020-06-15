package com.universodoandroid.starwarsjetpack.data.people.repository

import com.universodoandroid.starwarsjetpack.data.people.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.domain.people.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person

object PeoplePageDataMock {

    fun getPeoplePageData() = PeoplePageData(
        hasNextPage = false,
        people = getPeopleData()
    )

    fun getPeopleData() = listOf(
        getPersonData("0"),
        getPersonData("1")
    )

    fun getPersonData(id: String) = PersonData(
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
        name = "",
        skinColor = "",
        url = ""
    )

    fun getPeoplePage() = PeoplePage(
        hasNextPage = false,
        people = getPeople()
    )


    fun getPeople() = listOf(
        getPerson("0"),
        getPerson("1")
    )

    fun getPerson(id: String) = Person(
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
        name = "",
        skinColor = "",
        url = ""
    )
}