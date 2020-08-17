package com.universodoandroid.starwarsjetpack.presentation.navigation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationState
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationViewModel
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationReducer
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationStateEvent
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class NavigationViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val reducer = mock<NavigationReducer>()
    private val navigationViewModel = NavigationViewModel(reducer)

    @Test
    fun `selectCurrentScreen should set current`() {
        val expected = 0

        navigationViewModel.selectCurrentScreen(expected)

        verify(reducer).updateTo(NavigationStateEvent.SelectScreen(expected))
    }

    @Test
    fun `getCurrentScreen should return current screen selected`() {
        val expectedValue = 0
        val liveData = MutableLiveData<NavigationState>().apply {
            value = NavigationState(expectedValue)
        }

        whenever(reducer.getState()).thenReturn(liveData)

        val result = navigationViewModel.getCurrentScreen()

        verify(reducer).getState()
        assertEquals(expectedValue, result)
    }
}