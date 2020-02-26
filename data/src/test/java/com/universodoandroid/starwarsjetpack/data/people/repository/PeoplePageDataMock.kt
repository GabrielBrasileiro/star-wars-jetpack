package com.universodoandroid.starwarsjetpack.data.people.repository

import com.universodoandroid.starwarsjetpack.data.people.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData

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