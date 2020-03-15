package com.universodoandroid.starwarsjetpack.presentation.people.models.person

import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDetailsPresentation
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.Event

sealed class PersonEvent : Event {

    data class ShowUser(
        val user: PersonDetailsPresentation
    ) : PersonEvent()

    data class ShowError(
        val error: String
    ) : PersonEvent()

}