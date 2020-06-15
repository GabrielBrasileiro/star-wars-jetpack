package com.universodoandroid.starwarsjetpack.local.people.mapper

import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.local.people.data.PeopleDataMock
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import org.junit.Assert.assertEquals
import org.junit.Test

class PersonDataMapperTest {

    private val mapperData: Mapper<PersonEntity, PersonData> = PersonDataMapper()

    @Test
    fun mapperBuildingCorrectToData() {
        val personEntity = PeopleDataMock.getPersonEntity("0")
        val personData = mapperData.map(personEntity)

        assertEquals(personData.id, personEntity.id)
        assertEquals(personData.name, personEntity.name)
        assertEquals(personData.birthYear, personEntity.birthYear)
        assertEquals(personData.created, personEntity.created)
        assertEquals(personData.edited, personEntity.edited)
        assertEquals(personData.gender, personEntity.gender)
        assertEquals(personData.eyeColor, personEntity.eyeColor)
        assertEquals(personData.height, personEntity.height)
        assertEquals(personData.hairColor, personEntity.hairColor)
        assertEquals(personData.homeworld, personEntity.homeworld)
        assertEquals(personData.mass, personEntity.mass)
        assertEquals(personData.skinColor, personEntity.skinColor)
        assertEquals(personData.url, personEntity.url)
    }
}