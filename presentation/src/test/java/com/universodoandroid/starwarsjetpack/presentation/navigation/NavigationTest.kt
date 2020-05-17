package com.universodoandroid.starwarsjetpack.presentation.navigation

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationViewModel
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationReducer
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationStateEvent
import org.junit.Test

class NavigationTest {

    private val reducer = mock<NavigationReducer>()
    private val navigationViewModel = NavigationViewModel(reducer)

    @Test
    fun `showNavigationBar should set show navigation bar true`() {
        navigationViewModel.showNavigationBar()

        verify(reducer).updateTo(NavigationStateEvent.ShowBar)
    }

    @Test
    fun `showNavigationBar should set show navigation bar false`() {
        navigationViewModel.hideNavigationBar()

        verify(reducer).updateTo(NavigationStateEvent.HideBar)
    }
}