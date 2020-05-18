package com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer

import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationState
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.Reducer

internal class NavigationReducer : Reducer<NavigationState, NavigationStateEvent>(
    initialState = NavigationState()
) {

    override fun updateTo(stateEvent: NavigationStateEvent) = updateState {
        when (stateEvent) {
            is NavigationStateEvent.SelectScreen -> copy(screenSelected = stateEvent.screenId)
        }
    }
}