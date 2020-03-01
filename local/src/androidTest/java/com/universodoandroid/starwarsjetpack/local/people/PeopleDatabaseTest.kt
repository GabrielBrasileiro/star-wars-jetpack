package com.universodoandroid.starwarsjetpack.local.people

import com.universodoandroid.starwarsjetpack.local.BaseDatabaseTest
import com.universodoandroid.starwarsjetpack.local.people.dao.PersonDao
import com.universodoandroid.starwarsjetpack.local.people.data.PeopleEntityDataFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PeopleDatabaseTest : BaseDatabaseTest() {

    private lateinit var personDao: PersonDao

    private var dummyPeople = PeopleEntityDataFactory.dummyPeopleEntity()

    @Before
    fun setup() {
        personDao = appDatabase.personDao()
    }

    @Test
    fun insertPerson_shouldInsertPersonParam() {
        personDao.insertPeople(dummyPeople)
            .test()
            .assertComplete()
    }

    @Test
    fun getPeople_shouldReturnAllPeople() {
        personDao.insertPeople(dummyPeople)
            .test()
            .assertComplete()

        personDao.getPeople()
            .test()
            .assertValue {
                it.size == dummyPeople.count() && it.containsAll(dummyPeople)
            }
    }

    @Test
    fun getPerson_shouldReturnAnIndividualPerson() {
        val saveTest = personDao.insertPeople(dummyPeople).test()
        saveTest.assertComplete()

        personDao.getPerson(dummyPeople[0].id)
            .test()
            .assertValue {
                it.id == dummyPeople[0].id
            }
    }

    @Test
    fun isEmpty_shouldVerifyDatabaseNotHaveData() {
        personDao.isEmpty()
            .test()
            .assertValue {
                it == 0
            }
    }

    @Test
    fun eraseData_shouldEraseAllPeopleInDatabase() {
        personDao.insertPeople(dummyPeople)
            .test()
            .assertComplete()

        personDao.eraseData()
            .test()
            .assertComplete()

        personDao.isEmpty()
            .test()
            .assertValue {
                it == 0
            }
    }
}