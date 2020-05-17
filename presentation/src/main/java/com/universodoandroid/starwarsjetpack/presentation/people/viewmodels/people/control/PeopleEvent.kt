package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.control

import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.Event

sealed class PeopleEvent : Event {

    data class ShowError(
        val error: String
    ) : PeopleEvent()

    object HideLoading : PeopleEvent()
    object ShowLoading : PeopleEvent()
}