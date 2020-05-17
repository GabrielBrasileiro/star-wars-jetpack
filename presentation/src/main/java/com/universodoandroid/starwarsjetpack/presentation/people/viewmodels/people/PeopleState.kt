package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people

import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.State

data class PeopleState (
    val people: List<PersonPresentation> = listOf()
) : State