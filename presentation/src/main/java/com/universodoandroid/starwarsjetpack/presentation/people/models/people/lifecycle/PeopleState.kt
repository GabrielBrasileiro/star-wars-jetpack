package com.universodoandroid.starwarsjetpack.presentation.people.models.people.lifecycle

import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDto
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.State

data class PeopleState (
    val people: List<PersonDto>
) : State