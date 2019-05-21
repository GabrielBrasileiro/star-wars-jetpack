package com.universodoandroid.domain.people

data class PeopleResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Person>
)