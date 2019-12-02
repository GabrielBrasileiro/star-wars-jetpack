package com.universodoandroid.starwarsjetpack.data.entities

data class PeoplePage(
    val hasNextPage: Boolean,
    val people: List<Person>
)