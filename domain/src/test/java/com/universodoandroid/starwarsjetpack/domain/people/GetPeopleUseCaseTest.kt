package com.universodoandroid.starwarsjetpack.domain.people

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.domain.people.data.PeopleData
import com.universodoandroid.starwarsjetpack.domain.repositories.PeopleRepository
import com.universodoandroid.starwarsjetpack.domain.usecase.people.GetPeopleUseCase
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.quality.Strictness

class GetPeopleUseCaseTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    private val peopleRepository = mock<PeopleRepository>()

    private lateinit var getPeopleUseCase: GetPeopleUseCase

    @Before
    fun setup() {
        getPeopleUseCase = GetPeopleUseCase(
            peopleRepository
        )
    }

    @Test
    fun `getPeople Should return people When called`() {
        whenever(peopleRepository.getPeople())
            .thenReturn(Flowable.just(PeopleData.getPeople()))

        getPeopleUseCase.getPeople()
            .test()
            .assertComplete()
    }

}