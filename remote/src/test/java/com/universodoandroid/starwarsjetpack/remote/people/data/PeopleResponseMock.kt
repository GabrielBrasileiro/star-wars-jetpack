package com.universodoandroid.starwarsjetpack.remote.people.data

import com.universodoandroid.starwarsjetpack.data.people.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PeopleResponse
import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PersonItemResponse

internal object PeopleResponseMock {

    private const val firstItemName = "Darth Vader"
    private const val secondItemName = "Anakin Skywalker"

    fun getResponse(hasNext: String? = null) = PeopleResponse(
        count = 1,
        next = hasNext,
        previous = 0,
        results = listOf(
            PersonItemResponse(
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
                name = firstItemName,
                skinColor = "",
                species = ArrayList(),
                starships = ArrayList(),
                url = "",
                vehicles = ArrayList()
            ),
            PersonItemResponse(
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
                name = secondItemName,
                skinColor = "",
                species = ArrayList(),
                starships = ArrayList(),
                url = "",
                vehicles = ArrayList()
            )
        )
    )

    fun getData() = PeoplePageData(
        hasNextPage = false,
        people = listOf(
            PersonData(
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
                name = firstItemName,
                skinColor = "",
                url = ""
            ),
            PersonData(
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
                name = secondItemName,
                skinColor = "",
                url = ""
            )
        )
    )
}