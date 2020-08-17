package com.universodoandroid.starwarsjetpack.data.people.mappers

import com.universodoandroid.starwarsjetpack.data.people.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.domain.people.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper

internal class PeoplePageMapper(
    private val peopleMapper: Mapper<PersonData, Person>
) : Mapper<PeoplePageData, PeoplePage> {

    override fun map(enter: PeoplePageData): PeoplePage {
        return PeoplePage(
            hasNextPage = enter.hasNextPage,
            people = enter.people.map(peopleMapper::map)
        )
    }
}