package com.universodoandroid.starwarsjetpack.remote.people.remote.response


internal data class PeopleResponse(
    val count: Int,
    val next: String?,
    val previous: Any,
    val results: List<PersonItem>
)