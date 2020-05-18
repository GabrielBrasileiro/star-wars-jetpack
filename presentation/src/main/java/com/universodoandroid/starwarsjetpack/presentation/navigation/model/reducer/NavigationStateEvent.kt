package com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer

import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.StateEvent

sealed class NavigationStateEvent : StateEvent {

    data class SelectScreen(
        val screenId: Int?
    ) : NavigationStateEvent()
}