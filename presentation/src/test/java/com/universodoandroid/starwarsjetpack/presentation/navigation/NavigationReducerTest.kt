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
    fun `init Should start null screen`() {
        verify(state).onChanged(NavigationState(null))
    }

    @Test
    fun `update should select current screen`() {
        val expectedValue = 1

        reset(state)

        reducer.updateTo(NavigationStateEvent.SelectScreen(expectedValue))

        verify(state).onChanged(NavigationState(expectedValue))
    }
}