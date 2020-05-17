package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.control

import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.StateEvent

sealed class PeopleStateEvent :
    StateEvent {

    data class ShowPeopleData(
        val people: List<PersonPresentation>
    ) : PeopleStateEvent()
}