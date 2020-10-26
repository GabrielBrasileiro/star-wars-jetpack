package com.universodoandroid.starwarsjetpack.presentation.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.DefaultRXTestExecutor
import com.universodoandroid.starwarsjetpack.presentation.people.data.PeopleMock
import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PersonDetailsPresentationMapper
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person.PersonDetailsViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person.PersonEvent
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test

class PersonDetailsViewModelTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    private val observer = mock<Observer<PersonEvent>>()
    private val mapper = PersonDetailsPresentationMapper()
    private val getPersonUseCase = mock<GetPersonUseCase>()

    private val singleLiveEvent = SingleLiveEvent<PersonEvent>()

    private lateinit var viewModel: PersonDetailsViewModel

    @Test
    fun `loadPerson Should notify person details`() {
        val id = "0"
        val result = PeopleMock.buildPerson(id, "Gabriel")
        val expected = mapper.map(result)

        whenever(getPersonUseCase.loadPerson(id)).thenReturn(Single.just(result))

        createViewModel()

        viewModel.loadPerson(id)

        verify(observer).onChanged(PersonEvent.ShowUser(expected))
    }

    private fun createViewModel() {
        singleLiveEvent.observeForever(observer)

        viewModel = PersonDetailsViewModel(
            singleLiveEvent,
            getPersonUseCase,
            mapper,
            DefaultRXTestExecutor()
        )
    }
}