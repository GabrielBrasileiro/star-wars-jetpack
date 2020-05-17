package com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer

import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.StateEvent

sealed class NavigationStateEvent : StateEvent {

    object ShowBar : NavigationStateEvent()
    object HideBar : NavigationStateEvent()
}