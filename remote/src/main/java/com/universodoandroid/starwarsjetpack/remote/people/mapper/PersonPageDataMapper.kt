package com.universodoandroid.starwarsjetpack.remote.people.mapper

import com.universodoandroid.starwarsjetpack.data.people.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PeopleResponse
import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PersonItemResponse
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper

internal class PersonPageDataMapper :
    Mapper<PeopleResponse, PeoplePageData> {

    override fun map(enter: PeopleResponse): PeoplePageData {
        val hasNext = !enter.next.isNullOrBlank()

        return PeoplePageData(
            hasNextPage = hasNext,
            people = responseToEntities(enter.results)
        )
    }

    private fun fromResponse(personItemResponse: PersonItemResponse): PersonData {
        return PersonData(
            id = "",
            birthYear = personItemResponse.birthYear,
            created = personItemResponse.created,
            edited = personItemResponse.edited,
            eyeColor = personItemResponse.eyeColor,
            gender = personItemResponse.gender,
            hairColor = personItemResponse.hairColor,
            height = personItemResponse.height,
            homeworld = personItemResponse.homeworld,
            mass = personItemResponse.mass,
            name = personItemResponse.name,
            skinColor = personItemResponse.skinColor,
            url = personItemResponse.url
        )
    }

    private fun responseToEntities(response: List<PersonItemResponse>) = response.map(::fromResponse)

}