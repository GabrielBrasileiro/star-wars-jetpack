package com.universodoandroid.starwarsjetpack.presentation.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.RxSchedulerRule
import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PeopleMapper
import com.universodoandroid.starwarsjetpack.presentation.people.models.people.PeopleListViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.models.people.PeopleState
import io.reactivex.Flowable
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
        peopleViewModel = PeopleListViewModel(peopleUseCase).apply {
            getState().observeForever(peopleState)
        }
    }

    @Test
    fun `getPeople Should return a people list When called`() {
        val people = PeopleMock.withTwoPeople()
        val peopleDto = PeopleMapper.entityToDto(people)

        whenever(peopleUseCase.getPeople()).thenReturn(Flowable.just(people))

        peopleViewModel.loadPeople()

        inOrder(peopleState) {
            verify(peopleState).onChanged(PeopleState.ShowLoading)
            verify(peopleState).onChanged(PeopleState.HideLoading)
            verify(peopleState).onChanged(PeopleState.ShowData(peopleDto))
        }
    }

    @Test
    fun `getPeople Should return an error When called`() {
        val expectedErrorMessage = "Server error"
        val throwableWithLocalizedMessage = Throwable(expectedErrorMessage)

        whenever(peopleUseCase.getPeople()).thenReturn(Flowable.error(throwableWithLocalizedMessage))

        peopleViewModel.loadPeople()

        inOrder(peopleState) {
            verify(peopleState).onChanged(PeopleState.ShowLoading)
            verify(peopleState).onChanged(PeopleState.HideLoading)
            verify(peopleState).onChanged(PeopleState.ShowError(expectedErrorMessage))
        }
    }

}