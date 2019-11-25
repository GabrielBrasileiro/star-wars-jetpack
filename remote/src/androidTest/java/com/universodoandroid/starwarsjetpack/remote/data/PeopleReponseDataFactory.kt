package com.universodoandroid.starwarsjetpack.remote.data

import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PeopleResponse
import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PersonItem
import java.util.*
import kotlin.collections.ArrayList

object PeopleReponseDataFactory {

    fun dummyPeopleResponse() = PeopleResponse(
        count = 1,
        next = null,
        previous = 0,
        results = listOf(
            PersonItem(
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
            PersonItem(
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
    )

}