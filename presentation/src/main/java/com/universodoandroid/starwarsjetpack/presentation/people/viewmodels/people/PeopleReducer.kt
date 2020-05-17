package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people

import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.control.PeopleStateEvent
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.Reducer

class PeopleReducer : Reducer<PeopleState, PeopleStateEvent>(initialState = PeopleState()) {

    override fun updateTo(stateAction: PeopleStateEvent) = updateState {
        when (stateAction) {
            is PeopleStateEvent.ShowPeopleData -> copy(people = stateAction.people)
        }
    }
}
