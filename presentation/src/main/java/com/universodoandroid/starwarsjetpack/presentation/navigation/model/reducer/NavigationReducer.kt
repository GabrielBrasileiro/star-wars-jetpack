package com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer

import com.mvvmredux.core.reducer.ReducerScope
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationState

internal class NavigationReducer : ReducerScope<NavigationState, NavigationStateEvent>(
    initialState = NavigationState()
) {

    override fun updateTo(stateEvent: NavigationStateEvent) = updateState {
        when (stateEvent) {
            is NavigationStateEvent.SelectScreen -> copy(screenSelected = stateEvent.screenId)
        }
    }
}