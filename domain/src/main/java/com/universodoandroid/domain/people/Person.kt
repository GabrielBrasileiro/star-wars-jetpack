package com.universodoandroid.domain.people

data class Person(
    val id: String,
    val birth_year: String,
    val created: String,
    val edited: String,
    val eye_color: String,
    val films: List<String>? = null,
    val gender: String,
    val hair_color: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val skin_color: String,
    val species: List<String>? = null,
    val starships: List<String>? = null,
    val url: String,
    val vehicles: List<String>? = null
)