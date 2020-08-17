package com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer

import com.mvvmredux.core.stateevent.StateEvent

sealed class NavigationStateEvent : StateEvent {

    data class SelectScreen(
        val screenId: Int?
    ) : NavigationStateEvent()
}