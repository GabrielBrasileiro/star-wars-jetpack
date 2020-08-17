package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer

import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation
import com.mvvmredux.core.state.State

data class PeopleState (
    val people: List<PersonPresentation> = listOf()
) : State