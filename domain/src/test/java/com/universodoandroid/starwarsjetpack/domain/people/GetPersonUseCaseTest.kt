package com.universodoandroid.starwarsjetpack.domain.people

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.domain.people.data.PeopleData
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.quality.Strictness

class GetPersonUseCaseTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    private val peopleRepository = mock<PeopleRepository>()

    private lateinit var getPersonUseCase: GetPersonUseCase

    @Before
    fun setup() {
        getPersonUseCase =
            GetPersonUseCase(
                peopleRepository
            )
    }

    @Test
    fun `getPerson Should return person When called`() {
        val personId = "0"

        whenever(getPersonUseCase.loadPerson(personId))
            .thenReturn(Flowable.just(PeopleData.getPerson(personId)))

        getPersonUseCase.loadPerson("0")
            .test()
            .onComplete()
    }

}