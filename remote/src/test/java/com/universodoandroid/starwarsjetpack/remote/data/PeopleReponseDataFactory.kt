package com.universodoandroid.starwarsjetpack.remote.data

import com.universodoandroid.starwarsjetpack.remote.people.data.response.PeopleResponse
import com.universodoandroid.starwarsjetpack.remote.people.data.response.PersonItem

object PeopleReponseDataFactory {

    fun dummyPeopleResponse() = PeopleResponse(
        count = 1,
        next = null,
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
                name = "",
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
                name = "",
                skinColor = "",
                species = ArrayList(),
                starships = ArrayList(),
                url = "",
                vehicles = ArrayList()
            )
        )
    )

}