package com.universodoandroid.starwarsjetpack.presentation.people.dto

import java.io.Serializable

data class PersonDto(
    val id: String,
    val name: String,
    val planet: String,
    val imageUrl: String = ""
) : Serializable