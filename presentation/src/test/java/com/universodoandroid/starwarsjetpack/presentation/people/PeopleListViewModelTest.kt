package com.universodoandroid.starwarsjetpack.presentation.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.RxSchedulerRule
import com.universodoandroid.starwarsjetpack.presentation.people.data.PeopleMock
import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PeoplePresentationMapper
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.PeopleListViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer.PeopleEvent
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer.PeopleReducer
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer.PeopleStateEvent
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PeopleListViewModelTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    @get:Rule
    val rxRule = RxSchedulerRule()

    private val peopleUseCase = mock<GetPeopleUseCase>()
    private val peopleReducer = mock<PeopleReducer>()
    private val peopleEvent = mock<Observer<PeopleEvent>>()

    private val peoplePresentationMapper = PeoplePresentationMapper()

    private lateinit var peopleViewModel: PeopleListViewModel

    @Before
    fun setup() {
        reset(peopleUseCase)
    }

    @Test
    fun `getPeople Should return a people list When called`() {
        val people = PeopleMock.withTwoPeople()
        val peopleDto = people.map(peoplePresentationMapper::map)

        whenever(peopleUseCase.getPeople()).thenReturn(Single.just(people))

        createPeopleViewModel()

        inOrder(peopleEvent, peopleReducer) {
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

        createPeopleViewModel()

        inOrder(peopleEvent) {
            verify(peopleEvent).onChanged(PeopleEvent.ShowLoading)
            verify(peopleEvent).onChanged(PeopleEvent.ShowError(expectedErrorMessage))
            verify(peopleEvent).onChanged(PeopleEvent.HideLoading)
        }
    }

    private fun createPeopleViewModel() {
        val singleLiveEvent = SingleLiveEvent<PeopleEvent>().apply { observeForever(peopleEvent) }

        peopleViewModel = PeopleListViewModel(
            singleLiveEvent, peopleReducer, peopleUseCase, peoplePresentationMapper
        )
    }
}