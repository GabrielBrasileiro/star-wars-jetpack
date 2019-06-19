package com.universodoandroid.presentation.dto

import java.io.Serializable

data class PersonDto(
    val id: String,
    val name: String,
    val planet: String,
    val imageUrl: String = ""
) : Serializable