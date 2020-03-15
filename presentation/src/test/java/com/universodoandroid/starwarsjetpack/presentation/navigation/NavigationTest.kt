package com.universodoandroid.starwarsjetpack.presentation.navigation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationState
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val navigationViewModel = NavigationViewModel()
    private val navigationState = mock<Observer<NavigationState>>()

    @Before
    fun setup() {
        navigationViewModel.run {
            getState().observeForever(navigationState)
        }
    }

    @Test
    fun `showNavigationBar should set show navigation bar true`() {
        navigationViewModel.showNavigationBar()

        verify(navigationState).onChanged(NavigationState(true))
    }

    @Test
    fun `showNavigationBar should set show navigation bar false`() {
        navigationViewModel.hideNavigationBar()

        verify(navigationState).onChanged(NavigationState(false))
    }
}