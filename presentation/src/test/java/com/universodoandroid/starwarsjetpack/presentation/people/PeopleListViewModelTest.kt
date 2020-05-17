package com.universodoandroid.starwarsjetpack.presentation.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.RxSchedulerRule
import com.universodoandroid.starwarsjetpack.presentation.people.data.PeopleMock
import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PeoplePresentationMapper
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.PeopleListViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.PeopleReducer
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.control.PeopleEvent
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.control.PeopleStateEvent
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PeopleListViewModelTest {

    @get:Rule
    val rxRule = RxSchedulerRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val peopleUseCase = mock<GetPeopleUseCase>()
    private val peopleReducer = mock<PeopleReducer>()
    private val peopleEvent = mock<Observer<PeopleEvent>>()
    private val peoplePresentationMapper = PeoplePresentationMapper()

    private lateinit var peopleViewModel: PeopleListViewModel

    @Before
    fun setup() {
        reset(peopleUseCase, peopleEvent)

        peopleViewModel = PeopleListViewModel(
            peopleUseCase, peopleReducer, peoplePresentationMapper
        ).apply {
            getEvent().observeForever(peopleEvent)
        }
    }

    @After
    fun tearDown() {
        reset(peopleEvent, peopleReducer)
    }

    @Test
    fun `getPeople Should return a people list When called`() {
        val people = PeopleMock.withTwoPeople()
        val peopleDto = people.map { peoplePresentationMapper.map(it) }

        whenever(peopleUseCase.getPeople()).thenReturn(Single.just(people))

        peopleViewModel.loadPeople()

        inOrder(peopleReducer, peopleEvent) {
            verify(peopleEvent).onChanged(PeopleEvent.ShowLoading)
            verify(peopleReducer).updateTo(PeopleStateEvent.ShowPeopleData(peopleDto))
            verify(peopleEvent).onChanged(PeopleEvent.HideLoading)
        }
    }

    @Test
    fun `getPeople Should return an error When called`() {
        val expectedErrorMessage = "Server error"
        val throwableWithLocalizedMessage = Throwable(expectedErrorMessage)

        whenever(peopleUseCase.getPeople()).thenReturn(Single.error(throwableWithLocalizedMessage))

        peopleViewModel.loadPeople()

        inOrder(peopleEvent) {
            verify(peopleEvent).onChanged(PeopleEvent.ShowLoading)
            verify(peopleEvent).onChanged(PeopleEvent.ShowError(expectedErrorMessage))
            verify(peopleEvent).onChanged(PeopleEvent.HideLoading)
        }
    }
}