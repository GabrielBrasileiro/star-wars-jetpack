package com.universodoandroid.starwarsjetpack.data.people.repository

import com.nhaarman.mockitokotlin2.*
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleLocalData
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.data.people.mappers.PeopleDataMapper
import com.universodoandroid.starwarsjetpack.data.people.mappers.PeopleMapper
import com.universodoandroid.starwarsjetpack.data.people.mappers.PeoplePageMapper
import com.universodoandroid.starwarsjetpack.data.people.repository.PeoplePageDataMock.getPeoplePageData
import com.universodoandroid.starwarsjetpack.data.people.repository.PeoplePageDataMock.getPersonData
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Test

class PeopleRepositoryTest {

    private val localData = mock<PeopleLocalData>()
    private val remoteData = mock<PeopleRemoteData>()

    private val peopleMapper = PeopleMapper()
    private val peopleDataMapper = PeopleDataMapper()
    private val peoplePageMapper = PeoplePageMapper(peopleMapper)

    private lateinit var peopleRepository: PeopleRepository

    @Before
    fun setup() {
        peopleRepository = PeopleRepositoryImpl(
            remoteData,
            localData,
            peopleMapper,
            peopleDataMapper,
            peoplePageMapper
        )
    }

    @After
    fun tearDown() {
        reset(localData, remoteData)
    }

    @Test
    fun `getPeople Should call remote & local data source When preferences return false`() {
        val peoplePageData = getPeoplePageData()
        val peopleData = peoplePageData.people

        whenever(localData.wasCached()).thenReturn(false)
        whenever(remoteData.getAllPeopleData()).thenReturn(Flowable.just(peoplePageData))
        whenever(localData.savePeople(any())).thenReturn(Completable.complete())
        whenever(localData.getPeople()).thenReturn(Single.just(peopleData))

        peopleRepository.getPeople()
            .test()
            .assertNoErrors()
            .assertValue {
                it.size == peopleData.size && it[0].name == peopleData[0].name
            }

        verify(localData).registerCache(true)
    }

    @Test
    fun `getPeople Should call error When not complete first sync`() {
        whenever(remoteData.getAllPeopleData()).thenReturn(Flowable.error(Throwable()))
        whenever(localData.getPeople()).thenReturn(Single.error(Throwable()))

        peopleRepository.getPeople()
            .test()
            .assertNotComplete()

        verify(localData).deleteData()

        inOrder(localData) {
            verify(localData).registerCache(false)
            verify(localData).deleteData()
        }
    }

    @Test
    fun `getPeople Should call local data source When preferences return true`() {
        val peopleData =
            PeoplePageDataMock.getPeopleData()

        whenever(localData.wasCached()).thenReturn(true)
        whenever(localData.getPeople()).thenReturn(Single.just(peopleData))

        peopleRepository.getPeople()
            .test()
            .assertNoErrors()
            .assertValue {
                it.size == peopleData.size && it[0].name == peopleData[0].name
            }
    }

    @Test
    fun `getPeoplePerPage Should return a page with people When called`() {
        val peoplePage = getPeoplePageData()

        whenever(remoteData.getPeoplePerPage(any())).thenReturn(Flowable.just(peoplePage))

        peopleRepository.getPeoplePerPage(any())
            .test()
            .assertNoErrors()
            .assertValue {
                it.hasNextPage == peoplePage.hasNextPage && it.people[0].name == peoplePage.people[0].name
            }
    }

    @Test
    fun `saveLocalPeople Should save people`() {
        whenever(localData.savePeople(any())).thenReturn(Completable.complete())

        peopleRepository.saveLocalPeople(listOf())
            .test()
            .assertComplete()
    }

    @Test
    fun `getPeople Should return person When called`() {
        val expectedId = "0"

        whenever(localData.getPerson(any())).thenReturn(Single.just(getPersonData(expectedId)))

        peopleRepository.getPerson(expectedId)
            .test()
            .assertNoErrors()
            .assertValue {
                it.id == expectedId
            }
    }

    @Test
    fun `eraseData Should erase all people data from persistence When called`() {
        whenever(localData.deleteData()).thenReturn(Completable.complete())

        peopleRepository.eraseData()
            .test()
            .assertComplete()
    }
}