package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer

import com.mvvmredux.core.event.Event

sealed class PeopleEvent : Event {

    data class ShowError(
        val error: String
    ) : PeopleEvent()

    object HideLoading : PeopleEvent()
    object ShowLoading : PeopleEvent()
}