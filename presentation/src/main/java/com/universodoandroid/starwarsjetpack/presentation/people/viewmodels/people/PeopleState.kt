package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people

import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.State

data class PeopleState (
    val people: List<PersonPresentation>
) : State