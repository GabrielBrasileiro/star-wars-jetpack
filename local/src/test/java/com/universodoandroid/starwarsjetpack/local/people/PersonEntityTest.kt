package com.universodoandroid.local.people

import com.universodoandroid.starwarsjetpack.local.mapper.PersonMapper
import org.junit.Assert
import org.junit.Test


class PersonEntityTest {

    private val personDomain = PeopleDataFactory.dummyPersonDomain()
    private val personEntity = PeopleDataFactory.dummyPersonEntity()

    @Test
    fun mapperBuildingCorrectToData() {
        val convertedPerson = PersonMapper.toData(personDomain)

        Assert.assertEquals(personDomain.name, convertedPerson.name)
        Assert.assertEquals(personDomain.birthYear, convertedPerson.birthYear)
        Assert.assertEquals(personDomain.created, convertedPerson.created)
        Assert.assertEquals(personDomain.edited, convertedPerson.edited)
        Assert.assertEquals(personDomain.gender, convertedPerson.gender)
        Assert.assertEquals(personDomain.eyeColor, convertedPerson.eyeColor)
        Assert.assertEquals(personDomain.hairColor, convertedPerson.hairColor)
        Assert.assertEquals(personDomain.homeworld, convertedPerson.homeworld)
        Assert.assertEquals(personDomain.mass, convertedPerson.mass)
        Assert.assertEquals(personDomain.skinColor, convertedPerson.skinColor)
        Assert.assertEquals(personDomain.url, convertedPerson.url)
    }

    @Test
    fun mapperBuildingCorrectToEntity() {
        val convertedPerson = PersonMapper.fromData(personEntity)

        Assert.assertEquals(personEntity.id, convertedPerson.id)
        Assert.assertEquals(personEntity.name, convertedPerson.name)
        Assert.assertEquals(personEntity.birthYear, convertedPerson.birthYear)
        Assert.assertEquals(personEntity.created, convertedPerson.created)
        Assert.assertEquals(personEntity.edited, convertedPerson.edited)
        Assert.assertEquals(personEntity.gender, convertedPerson.gender)
        Assert.assertEquals(personEntity.eyeColor, convertedPerson.eyeColor)
        Assert.assertEquals(personEntity.hairColor, convertedPerson.hairColor)
        Assert.assertEquals(personEntity.homeworld, convertedPerson.homeworld)
        Assert.assertEquals(personEntity.mass, convertedPerson.mass)
        Assert.assertEquals(personEntity.skinColor, convertedPerson.skinColor)
        Assert.assertEquals(personEntity.url, convertedPerson.url)
    }

}