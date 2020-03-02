package com.universodoandroid.starwarsjetpack.remote.people.mapper

import com.universodoandroid.starwarsjetpack.data.people.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PeopleResponse
import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PersonItem
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

    private fun fromResponse(personItem: PersonItem): PersonData {
        return PersonData(
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
    }

    private fun responseToEntities(response: List<PersonItem>) = response.map(::fromResponse)

}