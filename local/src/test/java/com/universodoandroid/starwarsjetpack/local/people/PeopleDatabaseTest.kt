package com.universodoandroid.starwarsjetpack.local.people

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.local.people.dao.PersonDao
import com.universodoandroid.starwarsjetpack.local.people.data.PeopleDataMock.getPersonEntity
import com.universodoandroid.starwarsjetpack.local.people.database.PeopleDatabase
import com.universodoandroid.starwarsjetpack.local.people.database.PeopleDatabaseImpl
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Test

class PeopleDatabaseTest {

    private val dao = mock<PersonDao>()
    private val database: PeopleDatabase = PeopleDatabaseImpl(dao)

    @Test
    fun `loadPeople dao should return all saved people`() {
        val people = listOf(getPersonEntity("1"), getPersonEntity("2"))

        whenever(dao.getPeople()).thenReturn(Single.just(people))

        database.loadPeople()
            .test()
            .assertComplete()
            .assertValue(people)
    }

    @Test
    fun `loadPerson dao should return a unique saved person`() {
        val personId = "1"
        val person = getPersonEntity(personId)

        whenever(dao.getPerson(personId)).thenReturn(Single.just(person))

        database.loadPerson(personId)
            .test()
            .assertComplete()
            .assertValue(person)
    }

    @Test
    fun `savePeople dao should insert people`() {
        whenever(dao.insertPeople(any())).thenReturn(Completable.complete())

        database.savePeople(listOf())
            .test()
            .assertNoErrors()
            .assertComplete()
    }

    @Test
    fun `deleteData dao should delete people table`() {
        whenever(dao.deleteData()).thenReturn(Completable.complete())

        database.deleteData()
            .test()
            .assertNoErrors()
            .assertComplete()
    }
}