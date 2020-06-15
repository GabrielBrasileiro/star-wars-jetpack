package com.universodoandroid.starwarsjetpack.presentation.navigation.model

import com.mvvmredux.core.ext.requireStateValue
import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.core.state.StateViewModel
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationStateEvent

class NavigationViewModel(
    reducer: Reducer<NavigationState, NavigationStateEvent>
) : StateViewModel<NavigationState, NavigationStateEvent>(reducer) {

    fun selectCurrentScreen(screen: Int?) {
        updateTo(NavigationStateEvent.SelectScreen(screen))
    }

    fun getCurrentScreen(): Int? {
        return requireStateValue().screenSelected
    }
}