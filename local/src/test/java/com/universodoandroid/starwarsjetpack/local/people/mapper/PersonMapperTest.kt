package com.universodoandroid.starwarsjetpack.local.people.mapper

import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.local.people.mapper.PeopleDataMock.getPersonDomain
import com.universodoandroid.starwarsjetpack.local.people.mapper.PeopleDataMock.getPersonEntity
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import org.junit.Assert.assertEquals
import org.junit.Test

class PersonMapperTest {

    private val mapperData: Mapper<PersonEntity, PersonData> = PersonDataMapper()
    private val mapperEntity: Mapper<PersonData, PersonEntity> = PersonEntityMapper()

    @Test
    fun mapperBuildingCorrectToData() {
        val personEntity = getPersonEntity()
        val personData = mapperData.map(personEntity)

        assertEquals(personData.id, personEntity.id)
        assertEquals(personData.name, personEntity.name)
        assertEquals(personData.birthYear, personEntity.birthYear)
        assertEquals(personData.created, personEntity.created)
        assertEquals(personData.edited, personEntity.edited)
        assertEquals(personData.gender, personEntity.gender)
        assertEquals(personData.eyeColor, personEntity.eyeColor)
        assertEquals(personData.hairColor, personEntity.hairColor)
        assertEquals(personData.homeworld, personEntity.homeworld)
        assertEquals(personData.mass, personEntity.mass)
        assertEquals(personData.skinColor, personEntity.skinColor)
        assertEquals(personData.url, personEntity.url)
    }

    @Test
    fun mapperBuildingCorrectToEntity() {
        val personData = getPersonDomain()
        val personEntity = mapperEntity.map(personData)

        assertEquals(personEntity.name, personData.name)
        assertEquals(personEntity.birthYear, personData.birthYear)
        assertEquals(personEntity.created, personData.created)
        assertEquals(personEntity.edited, personData.edited)
        assertEquals(personEntity.gender, personData.gender)
        assertEquals(personEntity.eyeColor, personData.eyeColor)
        assertEquals(personEntity.hairColor, personData.hairColor)
        assertEquals(personEntity.homeworld, personData.homeworld)
        assertEquals(personEntity.mass, personData.mass)
        assertEquals(personEntity.skinColor, personData.skinColor)
        assertEquals(personEntity.url, personData.url)
    }
}