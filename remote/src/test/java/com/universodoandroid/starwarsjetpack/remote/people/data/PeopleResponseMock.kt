package com.universodoandroid.starwarsjetpack.remote.people.data

import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PeopleResponse
import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PersonItem

internal object PeopleResponseMock {

    fun getResponse(hasNext: String? = null) = PeopleResponse(
        count = 1,
        next = hasNext,
        previous = 0,
        results = listOf(
            PersonItem(
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
                name = "Darth Vader",
                skinColor = "",
                species = ArrayList(),
                starships = ArrayList(),
                url = "",
                vehicles = ArrayList()
            ),
            PersonItem(
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
                name = "Anakin Skywalker",
                skinColor = "",
                species = ArrayList(),
                starships = ArrayList(),
                url = "",
                vehicles = ArrayList()
            )
        )
    )

}