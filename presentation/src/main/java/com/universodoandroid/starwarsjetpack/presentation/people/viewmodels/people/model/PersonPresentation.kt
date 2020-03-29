package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model

import java.io.Serializable

data class PersonPresentation(
    val id: String,
    val name: String,
    val planet: String,
    val imageUrl: String? = null
) : Serializable