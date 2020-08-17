package com.universodoandroid.starwarsjetpack.presentation.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.universodoandroid.starwarsjetpack.presentation.people.data.PeopleMock
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer.PeopleReducer
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer.PeopleState
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer.PeopleStateEvent
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PeopleReducerTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val state = mock<Observer<PeopleState>>()
    private lateinit var reducer: PeopleReducer

    @Before
    fun setup() {
        reducer = PeopleReducer().apply { getState().observeForever(state) }
    }

    @Test
    fun `state should notify empty list`() {
        verify(state).onChanged(PeopleState(listOf()))
    }

    @Test
    fun `state should notify a list with people`() {
        val expected = PeopleMock.presentationWithTwoPeople()

        reducer.updateTo(PeopleStateEvent.ShowPeopleData(expected))

        verify(state).onChanged(PeopleState(expected))
    }
}