package com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer

import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationState
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.Reducer

class NavigationReducer : Reducer<NavigationState, NavigationStateEvent>(
    initialState = NavigationState()
) {

    override fun updateTo(stateAction: NavigationStateEvent) = updateState {
        when (stateAction) {
            is NavigationStateEvent.ShowBar -> copy(showNavBar = true)
            is NavigationStateEvent.HideBar -> copy(showNavBar = false)
        }
    }
}