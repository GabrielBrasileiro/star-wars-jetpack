package com.universodoandroid.starwarsjetpack.remote.mapper

import com.universodoandroid.starwarsjetpack.data.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.entities.PersonData
import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PeopleResponse
import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PersonItem

object PersonMapper {

    private fun fromResponse(personItem: PersonItem) =
        PersonData(
            id = "",
            birthYear = personItem.birthYear,
            created = personItem.created,
            edited = personItem.edited,
            eyeColor = personItem.eyeColor,
            gender = personItem.gender,
            hairColor = personItem.hairColor,
            height = personItem.height,
            homeworld = personItem.homeworld,
            mass = personItem.mass,
            name = personItem.name,
            skinColor = personItem.skinColor,
            url = personItem.url
        )

    fun responseToPeoplePage(peopleResponse: PeopleResponse): PeoplePageData {
        val hasNext = !peopleResponse.next.isNullOrBlank()

        return PeoplePageData(
            hasNextPage = hasNext,
            people = responseToEntities(
                peopleResponse.results
            )
        )
    }

    private fun responseToEntities(response: List<PersonItem>) = response.map(PersonMapper::fromResponse)

}