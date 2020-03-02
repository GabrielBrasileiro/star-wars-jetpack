package com.universodoandroid.starwarsjetpack.presentation.people.models.people.lifecycle

import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.Event

sealed class PeopleEvent : Event {

    data class ShowError(
        val error: String
    ) : PeopleEvent()

    object HideLoading : PeopleEvent()
    object ShowLoading : PeopleEvent()

}