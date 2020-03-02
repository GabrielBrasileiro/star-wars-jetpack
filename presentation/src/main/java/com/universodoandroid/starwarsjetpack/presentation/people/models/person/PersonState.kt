package com.universodoandroid.starwarsjetpack.presentation.people.models.person

import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDetailsDto
import com.universodoandroid.starwarsjetpack.presentation.utils.ViewState

sealed class PersonState : ViewState {

    data class ShowUser(
        val user: PersonDetailsDto
    ) : PersonState()

    data class ShowError(
        val error: String
    ) : PersonState()

}