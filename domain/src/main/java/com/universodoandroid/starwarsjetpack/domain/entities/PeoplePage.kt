package com.universodoandroid.starwarsjetpack.domain.entities

data class PeoplePage(
    val hasNextPage: Boolean,
    val people: List<Person>
)