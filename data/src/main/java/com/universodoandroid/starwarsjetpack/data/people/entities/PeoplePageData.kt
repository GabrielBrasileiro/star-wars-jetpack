package com.universodoandroid.starwarsjetpack.data.people.entities

data class PeoplePageData(
    val hasNextPage: Boolean,
    val people: List<PersonData>
)