package com.universodoandroid.starwarsjetpack.data.people

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.data.global.CacheType
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleLocalData
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeoplePreferences
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.data.people.source.PeopleRepositoryImpl
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test

class PeopleRepositoryTest {

    private val localData = mock<PeopleLocalData>()
    private val remoteData = mock<PeopleRemoteData>()
    private val preferences = mock<PeoplePreferences>()

    private lateinit var peopleRepository: PeopleRepository

    @Before
    fun setup() {
        peopleRepository = PeopleRepositoryImpl(remoteData, localData, preferences)
    }

    @Test
    fun `getPeople Should call remote & local data source When preferences return false`() {
        val peoplePageData = PeoplePageDataMock.getPeoplePageData()
        val peopleData = peoplePageData.people

        whenever(preferences.isDownloaded(CacheType.PEOPLE_CACHE)).thenReturn(false)
        whenever(remoteData.getAllPeopleData()).thenReturn(Flowable.just(peoplePageData))
        whenever(localData.savePeople(any())).thenReturn(Completable.complete())
        whenever(localData.getPeople()).thenReturn(Flowable.just(peopleData))

        peopleRepository.getPeople()
            .test()
            .assertNoErrors()
            .assertValue {
                it.size == peopleData.size && it[0].name == peopleData[0].name
            }
    }

    @Test
    fun `getPeople Should call local data source When preferences return true`() {
        val peopleData = PeoplePageDataMock.getPeopleData()

        whenever(preferences.isDownloaded(CacheType.PEOPLE_CACHE)).thenReturn(true)
        whenever(localData.getPeople()).thenReturn(Flowable.just(peopleData))

        peopleRepository.getPeople()
            .test()
            .assertNoErrors()
            .assertValue {
                it.size == peopleData.size && it[0].name == peopleData[0].name
            }
    }

}