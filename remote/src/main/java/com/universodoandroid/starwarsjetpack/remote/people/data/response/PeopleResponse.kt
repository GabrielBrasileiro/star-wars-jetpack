package com.universodoandroid.starwarsjetpack.remote.people.data.response


data class PeopleResponse(
    val count: Int,
    val next: String?,
    val previous: Any,
    val results: List<PersonItem>
)