package com.universodoandroid.starwarsjetpack.domain.people.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.domain.people.data.PeopleMock
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.quality.Strictness

class GetPersonUseCaseTest {

    private val peopleRepository = mock<PeopleRepository>()
    private val getPersonUseCase = GetPersonUseCase(peopleRepository)

    @Test
    fun `getPerson Should return person When called`() {
        val personId = "0"
        val expected = PeopleMock.getPerson(personId)

        whenever(peopleRepository.getPerson(personId)).thenReturn(Single.just(expected))

        getPersonUseCase.loadPerson("0")
            .test()
            .assertComplete()
            .assertValue(expected)
    }
}