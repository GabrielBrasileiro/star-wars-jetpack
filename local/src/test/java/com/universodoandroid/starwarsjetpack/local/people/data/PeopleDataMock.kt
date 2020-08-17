package com.universodoandroid.starwarsjetpack.local.people.data

import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity

internal object PeopleDataMock {

    private const val defaultImgUrl = "http://image"
    private const val defaultPersonName = "Skywalker"

    fun getPersonEntity(id: String) =
        PersonEntity(
            id = id,
            imgUrl = defaultImgUrl,
            birthYear = "05/05/1999",
            created = "05/05/2018",
            edited = "05/05/2019",
            eyeColor = "Blue",
            gender = "Man",
            hairColor = "Yellow",
            height = "1.75",
            homeworld = "Earth",
            mass = "55",
            name = defaultPersonName,
            skinColor = "White",
            url = "..."
        )

    fun getPersonData(id: String) = PersonData(
        id = id,
        imgUrl = defaultImgUrl,
        birthYear = "05/05/1999",
        created = "05/05/2018",
        edited = "05/05/2019",
        eyeColor = "Blue",
        gender = "Man",
        hairColor = "Yellow",
        height = "1.75",
        homeworld = "Earth",
        mass = "55",
        name = defaultPersonName,
        skinColor = "White",
        url = "..."
    )

    fun getPersonDataWithoutIdAndImg() = getPersonData("0").copy(
        id = "",
        imgUrl = ""
    )

    fun getDefaultImgUrl() = defaultImgUrl

    fun getDefaultPersonName() = defaultPersonName
}