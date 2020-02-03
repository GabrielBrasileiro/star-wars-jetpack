package com.universodoandroid.starwarsjetpack.data.people

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.data.global.CacheType
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleLocalData
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeoplePreferences
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.data.people.source.PeopleRepositoryImpl
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
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
    fun `getPeople Should call remote data When preferences return false`() {
        whenever(preferences.isDownloaded(CacheType.PEOPLE_CACHE)).thenReturn(false)

        peopleRepository.getPeople()
    }

}