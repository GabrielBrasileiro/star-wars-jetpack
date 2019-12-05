package com.universodoandroid.starwarsjetpack.data.entities

data class PeoplePageData(
    val hasNextPage: Boolean,
    val people: List<PersonData>
)