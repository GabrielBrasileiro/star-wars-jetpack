package com.universodoandroid.starwarsjetpack.remote.people

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.remote.people.data.PeopleRemoteDataImpl
import com.universodoandroid.starwarsjetpack.remote.people.data.PeopleResponseMock.getResponse
import com.universodoandroid.starwarsjetpack.remote.people.mapper.PersonPageDataMapper
import com.universodoandroid.starwarsjetpack.remote.people.remote.PeopleRemoteDataSource
import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PeopleResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

class PeopleRemoteDataTest {

    private val remoteDataSource = mock<PeopleRemoteDataSource>()
    private lateinit var peopleRemoteData: PeopleRemoteData

    @Before
    fun setup() {
        peopleRemoteData = PeopleRemoteDataImpl(remoteDataSource, PersonPageDataMapper())
    }

    @Test
    fun `getAllPeople should return pages when has next not null or blank`() {
        val response = getResponse("##")
        val expectedPeopleNumber = 4

        val peopleNumber = AtomicInteger(0)
        val cannotContinue = AtomicBoolean(false)

        val just = Flowable.create<PeopleResponse>({ emitter ->
            if (cannotContinue.get()) {
                emitter.onNext(response.copy(next = null))
            } else {
                cannotContinue.set(true)
                emitter.onNext(response)
            }
        }, BackpressureStrategy.BUFFER).doOnNext {
            peopleNumber.getAndAdd(it.results.size)
        }

        whenever(remoteDataSource.loadPeoplePerPage(any())).thenReturn(just)

        peopleRemoteData.getAllPeopleData()
            .test()
            .assertNoErrors()

        assertEquals(peopleNumber.get(), expectedPeopleNumber)
    }

    @Test
    fun `getPeoplePerPage Should return a data page`() {
        val page = 0

        whenever(remoteDataSource.loadPeoplePerPage(any())).thenReturn(Flowable.just(getResponse()))

        peopleRemoteData.getPeoplePerPage(page)
            .test()
            .assertComplete()
            .assertValue {
                val results = it.people
                results[0].name == "Darth Vader" && results[1].name == "Anakin Skywalker"
            }
    }
}