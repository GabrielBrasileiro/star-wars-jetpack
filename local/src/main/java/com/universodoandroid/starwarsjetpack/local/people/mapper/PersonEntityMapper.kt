package com.universodoandroid.starwarsjetpack.local.people.mapper

import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity
import com.universodoandroid.starwarsjetpack.local.people.mapper.imgs.DefaultPeopleImages
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import java.util.*

internal class PersonEntityMapper(
    private val defaultImages: DefaultPeopleImages
) : Mapper<PersonData, PersonEntity> {

    override fun map(enter: PersonData): PersonEntity {
        return PersonEntity(
            id = UUID.randomUUID().toString(),
            imgUrl = getImagePerName(enter.name),
            birthYear = enter.birthYear,
            created = enter.created,
            edited = enter.edited,
            eyeColor = enter.eyeColor,
            gender = enter.gender,
            hairColor = enter.hairColor,
            height = enter.height,
            homeworld = enter.homeworld,
            mass = enter.mass,
            name = enter.name,
            skinColor = enter.skinColor,
            url = enter.url
        )
    }

    private fun getImagePerName(name: String?): String? {
        return defaultImages.images[name]
    }
}