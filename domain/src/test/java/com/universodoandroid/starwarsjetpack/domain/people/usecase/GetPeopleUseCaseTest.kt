package com.universodoandroid.starwarsjetpack.domain.people.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.domain.people.data.PeopleMock
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import io.reactivex.Single
import org.junit.Test

class GetPeopleUseCaseTest {

    private val peopleRepository = mock<PeopleRepository>()
    private val getPeopleUseCase: GetPeopleUseCase = GetPeopleUseCase(peopleRepository)

    @Test
    fun `getPeople Should return people When called`() {
        val expectedResult = PeopleMock.getPeople()

        whenever(peopleRepository.getPeople()).thenReturn(Single.just(expectedResult))

        getPeopleUseCase.getPeople()
            .test()
            .assertComplete()
            .assertValue(expectedResult)
    }

}