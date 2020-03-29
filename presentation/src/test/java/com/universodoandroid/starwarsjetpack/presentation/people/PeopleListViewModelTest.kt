package com.universodoandroid.starwarsjetpack.presentation.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.RxSchedulerRule
import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PeoplePresentationMapper
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.PeopleListViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.PeopleEvent
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.PeopleState
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.quality.Strictness

class PeopleListViewModelTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    @get:Rule
    val rxRule = RxSchedulerRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val peopleUseCase = mock<GetPeopleUseCase>()
    private val peopleState = mock<Observer<PeopleState>>()
    private val peopleEvent = mock<Observer<PeopleEvent>>()
    private val peoplePresentationMapper = PeoplePresentationMapper()

    private lateinit var peopleViewModel: PeopleListViewModel

    @Before
    fun setup() {
        peopleViewModel = PeopleListViewModel(
            peopleUseCase, peoplePresentationMapper
        ).apply {
            getEvent().observeForever(peopleEvent)
            getState().observeForever(peopleState)
        }
    }

    @After
    fun tearDown() {
        reset(peopleEvent, peopleState)
    }

    @Test
    fun `getPeople Should return a people list When called`() {
        val people = PeopleMock.withTwoPeople()
        val peopleDto = people.map { peoplePresentationMapper.map(it) }

        whenever(peopleUseCase.getPeople()).thenReturn(Single.just(people))

        peopleViewModel.loadPeople()

        inOrder(peopleState, peopleEvent) {
            verify(peopleEvent).onChanged(PeopleEvent.ShowLoading)
            verify(peopleState).onChanged(
                PeopleState(
                    peopleDto
                )
            )
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