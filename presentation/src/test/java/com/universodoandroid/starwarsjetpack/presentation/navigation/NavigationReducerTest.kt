package com.universodoandroid.starwarsjetpack.presentation.navigation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.verify
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationState
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationReducer
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationStateEvent
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationReducerTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val state = mock<Observer<NavigationState>>()
    private lateinit var reducer: NavigationReducer

    @Before
    fun setup() {
        reducer = NavigationReducer().apply { getState().observeForever(state) }
    }

    @Test
    fun `init Should start with true`() {
        verify(state).onChanged(NavigationState(true))
    }

    @Test
    fun `update Should set state to true`() {
        reset(state)

        reducer.updateTo(NavigationStateEvent.ShowBar)

        verify(state).onChanged(NavigationState(true))
    }

    @Test
    fun `update Should set state to false`() {
        reset(state)

        reducer.updateTo(NavigationStateEvent.HideBar)

        verify(state).onChanged(NavigationState(false))
    }
}