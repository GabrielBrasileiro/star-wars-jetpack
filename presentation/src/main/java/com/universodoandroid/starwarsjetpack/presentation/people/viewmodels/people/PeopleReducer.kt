package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people

import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.control.PeopleStateEvent
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.Reducer

internal class PeopleReducer : Reducer<PeopleState, PeopleStateEvent>(initialState = PeopleState()) {

    override fun updateTo(stateEvent: PeopleStateEvent) = updateState {
        when (stateEvent) {
            is PeopleStateEvent.ShowPeopleData -> copy(people = stateEvent.people)
        }
    }
}
