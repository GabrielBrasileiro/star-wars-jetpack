package com.universodoandroid.starwarsjetpack.local.people.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class PersonEntity(
    @PrimaryKey
    var id: String,
    var imgUrl: String?,
    var birthYear: String,
    var created: String,
    var edited: String,
    var eyeColor: String,
    var gender: String,
    var hairColor: String,
    var height: String,
    var homeworld: String,
    var mass: String,
    var name: String,
    var skinColor: String,
    var url: String
)