package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer

import com.mvvmredux.core.reducer.ReducerScope

internal class PeopleReducer : ReducerScope<PeopleState, PeopleStateEvent>(PeopleState()) {

    override fun updateTo(stateEvent: PeopleStateEvent) = updateState {
        when (stateEvent) {
            is PeopleStateEvent.ShowPeopleData -> copy(people = stateEvent.people)
        }
    }
}
