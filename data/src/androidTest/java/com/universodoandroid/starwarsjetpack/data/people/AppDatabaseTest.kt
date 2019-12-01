package com.universodoandroid.local.people

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.universodoandroid.starwarsjetpack.data.AppDatabase
import com.universodoandroid.local.BaseDatabaseTest
import com.universodoandroid.local.people.data.PeopleEntityDataFactory
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AppDatabaseTest: BaseDatabaseTest() {

    private lateinit var appDatabase: AppDatabase

    private var dummyPeople = PeopleEntityDataFactory.dummyPeopleEntity()

    @Before
    fun initDatabase() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context, AppDatabase::class.java
        ).build()
    }

    @After
    fun closeDatabase() {
        appDatabase.close()
    }

    @Test
    fun insertPerson() {
        val test = appDatabase.personDao().insertPeople(dummyPeople).test()
        test.assertComplete()
    }

    @Test
    fun getPeople() {
        val dao = appDatabase.personDao()

        val saveTest = dao.insertPeople(dummyPeople).test()
        saveTest.assertComplete()

        dao.getPeople().test().assertValue {
            it.size == dummyPeople.count() && it.containsAll(dummyPeople)
        }
    }

    @Test
    fun getPerson() {
        val dao = appDatabase.personDao()

        val saveTest = dao.insertPeople(dummyPeople).test()
        saveTest.assertComplete()

        dao.getPerson(dummyPeople[0].id).test().assertValue {
            it.id == dummyPeople[0].id
        }
    }

}