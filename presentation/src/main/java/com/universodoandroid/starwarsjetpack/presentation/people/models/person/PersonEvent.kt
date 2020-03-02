package com.universodoandroid.starwarsjetpack.presentation.people.models.person

import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDetailsDto
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.Event

sealed class PersonEvent : Event {

    data class ShowUser(
        val user: PersonDetailsDto
    ) : PersonEvent()

    data class ShowError(
        val error: String
    ) : PersonEvent()

}