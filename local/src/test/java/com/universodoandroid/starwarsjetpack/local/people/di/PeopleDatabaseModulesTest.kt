package com.universodoandroid.starwarsjetpack.local.people.di

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.local.AppDatabase
import com.universodoandroid.starwarsjetpack.local.people.dao.PersonDao
import org.junit.Before
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.test.check.checkModules

class PeopleDatabaseModulesTest {

    private val appDatabase = mock<AppDatabase>()
    private val personDao = mock<PersonDao>()

    private val modules = module {
        single { appDatabase }
    }

    @Before
    fun setup() {
        whenever(appDatabase.personDao()).thenReturn(personDao)
    }

    @Test
    fun `people database should Provide People Database Dependencies`() {
        koinApplication {
            modules(listOf(
                modules,
                getPeopleDatabaseModules()
            ))
        }.checkModules()
    }
}