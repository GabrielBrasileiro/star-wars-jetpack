package com.universodoandroid.starwarsjetpack.presentation.navigation.model

import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.StateViewModel

class NavigationViewModel: StateViewModel<NavigationState>() {

    fun showNavigationBar() {
        setState(NavigationState(true))
    }

    fun hideNavigationBar() {
        setState(NavigationState(false))
    }
}