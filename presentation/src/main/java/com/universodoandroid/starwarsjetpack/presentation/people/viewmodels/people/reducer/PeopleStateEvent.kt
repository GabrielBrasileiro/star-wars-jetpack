package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer

import com.mvvmredux.core.stateevent.StateEvent
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation

sealed class PeopleStateEvent : StateEvent {

    data class ShowPeopleData(
        val people: List<PersonPresentation>
    ) : PeopleStateEvent()
}