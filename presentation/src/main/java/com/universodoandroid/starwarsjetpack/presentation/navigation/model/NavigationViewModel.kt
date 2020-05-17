package com.universodoandroid.starwarsjetpack.presentation.navigation.model

import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationReducer
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationStateEvent
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.StateViewModel

class NavigationViewModel(
    private val reducer: NavigationReducer
): StateViewModel<NavigationState>(reducer) {

    fun showNavigationBar() {
        reducer.updateTo(NavigationStateEvent.ShowBar)
    }

    fun hideNavigationBar() {
        reducer.updateTo(NavigationStateEvent.HideBar)
    }
}