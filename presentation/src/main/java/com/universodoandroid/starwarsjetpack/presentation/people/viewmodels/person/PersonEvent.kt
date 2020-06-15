package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person

import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person.model.PersonDetailsPresentation
import com.mvvmredux.core.event.Event

sealed class PersonEvent : Event {

    data class ShowUser(
        val user: PersonDetailsPresentation
    ) : PersonEvent()

    data class ShowError(
        val error: String
    ) : PersonEvent()

}