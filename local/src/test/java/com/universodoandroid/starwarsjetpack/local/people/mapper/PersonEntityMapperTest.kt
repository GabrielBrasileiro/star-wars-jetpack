package com.universodoandroid.starwarsjetpack.local.people.mapper

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.local.people.data.PeopleDataMock.getDefaultPersonName
import com.universodoandroid.starwarsjetpack.local.people.data.PeopleDataMock.getPersonDataWithoutIdAndImg
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity
import com.universodoandroid.starwarsjetpack.local.people.mapper.identifier.IdentifierGenerator
import com.universodoandroid.starwarsjetpack.local.people.mapper.imgs.DefaultPeopleImages
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PersonEntityMapperTest {

    private val defaultId = "0"
    private val defaultImgUrl = "https://mock"

    private val defaultPeopleImages = mock<DefaultPeopleImages>()
    private val identifierGenerator = mock<IdentifierGenerator>()

    private val mapperEntity: Mapper<PersonData, PersonEntity> =
        PersonEntityMapper(identifierGenerator, defaultPeopleImages)

    @Before
    fun setup() {
        whenever(defaultPeopleImages.getImage(any())).thenReturn(defaultImgUrl)
        whenever(identifierGenerator.getId()).thenReturn(defaultId)
    }

    @Test
    fun mapperBuildingCorrectToEntity() {
        val expectedId = "uuid"
        val expectedImage = "http://"

        val personData = getPersonDataWithoutIdAndImg()

        whenever(defaultPeopleImages.getImage(getDefaultPersonName())).thenReturn(expectedImage)
        whenever(identifierGenerator.getId()).thenReturn(expectedId)

        val personEntity = mapperEntity.map(personData)

        assertEquals(personEntity.id, expectedId)
        assertEquals(personEntity.imgUrl, expectedImage)
        assertEquals(personEntity.name, personData.name)
        assertEquals(personEntity.birthYear, personData.birthYear)
        assertEquals(personEntity.created, personData.created)
        assertEquals(personEntity.edited, personData.edited)
        assertEquals(personEntity.gender, personData.gender)
        assertEquals(personEntity.eyeColor, personData.eyeColor)
        assertEquals(personEntity.height, personData.height)
        assertEquals(personEntity.hairColor, personData.hairColor)
        assertEquals(personEntity.homeworld, personData.homeworld)
        assertEquals(personEntity.mass, personData.mass)
        assertEquals(personEntity.skinColor, personData.skinColor)
        assertEquals(personEntity.url, personData.url)
    }
}