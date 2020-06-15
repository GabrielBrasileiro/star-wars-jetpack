package com.universodoandroid.starwarsjetpack.remote.people

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.remote.people.data.PeopleResponseMock.getResponse
import com.universodoandroid.starwarsjetpack.remote.people.api.PeopleApi
import com.universodoandroid.starwarsjetpack.remote.people.remote.PeopleRemoteDataSource
import com.universodoandroid.starwarsjetpack.remote.people.remote.PeopleRemoteDataSourceImpl
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test

class PeopleRemoteDataSourceTest {

    private val peopleApiDataSource = mock<PeopleApi>()

    private lateinit var peopleRemoteDataSource: PeopleRemoteDataSource

    @Before
    fun setup() {
        peopleRemoteDataSource = PeopleRemoteDataSourceImpl(peopleApiDataSource)
    }

    @Test
    fun `loadPeoplePerPage Should return a page When called`() {
        val page = 0
        val expectedResponse = getResponse()

        whenever(peopleApiDataSource.loadPeople(page)).thenReturn(Flowable.just(expectedResponse))

        peopleRemoteDataSource.loadPeoplePerPage(page)
            .test()
            .assertComplete()
            .assertValue(expectedResponse)
    }
}