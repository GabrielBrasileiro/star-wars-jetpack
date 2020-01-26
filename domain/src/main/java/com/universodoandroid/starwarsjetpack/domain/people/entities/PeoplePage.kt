package com.universodoandroid.starwarsjetpack.domain.people.entities

data class PeoplePage(
    val hasNextPage: Boolean,
    val people: List<Person>
)