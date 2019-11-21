package com.universodoandroid.remote.data

import com.universodoandroid.domain.entities.people.PeopleResponse
import com.universodoandroid.domain.entities.people.Person
import java.util.*
import kotlin.collections.ArrayList

object PeopleReponseDataFactory {

    fun dummyPeopleResponse() = PeopleResponse(
        count = 1,
        next = null,
        previous = 0,
        results = listOf(
            Person(
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
            Person(
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