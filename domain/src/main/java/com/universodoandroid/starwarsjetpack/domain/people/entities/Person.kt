package com.universodoandroid.starwarsjetpack.domain.people.entities

data class Person(
    val id: String,
    val imgUrl: String? = null,
    val birthYear: String,
    val created: String,
    val edited: String,
    val eyeColor: String,
    val films: List<String>? = null,
    val gender: String,
    val hairColor: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val skinColor: String,
    val species: List<String>? = null,
    val starships: List<String>? = null,
    val url: String,
    val vehicles: List<String>? = null
)