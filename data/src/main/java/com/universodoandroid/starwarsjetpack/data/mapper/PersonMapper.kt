package com.universodoandroid.starwarsjetpack.data.mapper

import com.universodoandroid.starwarsjetpack.data.entity.PersonEntity
import com.universodoandroid.starwarsjetpack.domain.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PeopleResponse
import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PersonItem
import java.util.*

internal object PersonMapper {

    fun toData(person: Person) =
        PersonEntity(
            id = UUID.randomUUID().toString(),
            birthYear = person.birthYear,
            created = person.created,
            edited = person.edited,
            eyeColor = person.eyeColor,
            gender = person.gender,
            hairColor = person.hairColor,
            height = person.height,
            homeworld = person.homeworld,
            mass = person.mass,
            name = person.name,
            skinColor = person.skinColor,
            url = person.url
        )

    fun fromData(personEntity: PersonEntity) =
        Person(
            id = personEntity.id,
            birthYear = personEntity.birthYear,
            created = personEntity.created,
            edited = personEntity.edited,
            eyeColor = personEntity.eyeColor,
            gender = personEntity.gender,
            hairColor = personEntity.hairColor,
            height = personEntity.height,
            homeworld = personEntity.homeworld,
            mass = personEntity.mass,
            name = personEntity.name,
            skinColor = personEntity.skinColor,
            url = personEntity.url
        )

    private fun fromResponse(personItem: PersonItem) =
        Person(
            id = personItem.id,
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

    fun responseToPeoplePage(peopleResponse: PeopleResponse): PeoplePage {
        val hasNext = peopleResponse.next.isNullOrEmpty()

        return PeoplePage(
            hasNextPage = hasNext,
            people = responseToEntities(
                peopleResponse.results
            )
        )
    }

    private fun responseToEntities(response: List<PersonItem>) = response.map(PersonMapper::fromResponse)

    fun dataEntitiesToEntities(dataEntities: List<PersonEntity>) = dataEntities.map(
        PersonMapper::fromData
    )

    fun entitiesToDataEntities(entities: List<Person>) = entities.map(PersonMapper::toData)


}