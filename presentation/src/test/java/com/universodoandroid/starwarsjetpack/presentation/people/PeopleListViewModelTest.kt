package com.universodoandroid.starwarsjetpack.presentation.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.*
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.RxSchedulerRule
import com.universodoandroid.starwarsjetpack.presentation.people.models.people.PeopleListViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.models.people.PeopleState
import io.reactivex.Flowable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PeopleListViewModelTest {

    @get:Rule
    val rxRule = RxSchedulerRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val peopleUseCase = mock<GetPeopleUseCase>()
    private val peopleState = mock<Observer<PeopleState>>()

    private lateinit var peopleViewModel: PeopleListViewModel

    @Before
    fun setup() {
        peopleViewModel = PeopleListViewModel(peopleUseCase)

        peopleViewModel.getState().observeForever(peopleState)
    }

    @Test
    fun `getPeople Should return a people list When called`() {
        val people = PeopleMock.withTwoPeople()

        whenever(peopleUseCase.getPeople()).thenReturn(Flowable.just(people))

        peopleViewModel.loadPeople()

        inOrder(peopleState) {
            verify(peopleState).onChanged(PeopleState.ShowLoading)
            verify(peopleState).onChanged(PeopleState.HideLoading)
        }
    }

}