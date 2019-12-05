package com.universodoandroid.starwarsjetpack.data.mappers

import com.universodoandroid.starwarsjetpack.data.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.entities.PersonData
import com.universodoandroid.starwarsjetpack.domain.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.entities.Person


object PeopleDataMapper {

    fun dataToEntity(personData: PersonData) = Person(
        id = personData.id,
        birthYear = personData.birthYear,
        created = personData.created,
        edited = personData.edited,
        eyeColor = personData.eyeColor,
        gender = personData.gender,
        hairColor = personData.hairColor,
        height = personData.height,
        homeworld = personData.homeworld,
        mass = personData.mass,
        name = personData.name,
        skinColor = personData.skinColor,
        url = personData.url
    )

    fun entityToData(person: Person) = PersonData(
        id = person.id,
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

    fun entityPageToDataPage(peoplePageData: PeoplePageData) = PeoplePage(
        hasNextPage = peoplePageData.hasNextPage,
        people = peoplePageData.people.map(::dataToEntity)
    )

    fun dataToEntities(dataEntities: List<PersonData>) = dataEntities.map(::dataToEntity)

}