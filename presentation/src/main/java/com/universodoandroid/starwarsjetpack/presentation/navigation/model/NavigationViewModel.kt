package com.universodoandroid.starwarsjetpack.presentation.navigation.model

import com.universodoandroid.starwarsjetpack.presentation.extensions.requireStateValue
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationStateEvent
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.Reducer
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.StateViewModel

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