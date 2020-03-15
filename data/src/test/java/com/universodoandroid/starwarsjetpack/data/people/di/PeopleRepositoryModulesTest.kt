package com.universodoandroid.starwarsjetpack.data.people.di

import com.nhaarman.mockitokotlin2.mock
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleLocalData
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleRemoteData
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.test.check.checkModules

class PeopleRepositoryModulesTest {

    private val peopleLocalDataSource = mock<PeopleLocalData>()
    private val peopleRemoteDataSource = mock<PeopleRemoteData>()

    private val peopleDependencies = module {
        factory { peopleLocalDataSource }
        factory { peopleRemoteDataSource }
    }

    @Test
    fun `getPeopleRepositoryModules should load people repository dependencies`() {
        koinApplication {
            modules(listOf(peopleDependencies) + getPeopleRepositoryModule())
        }.checkModules()
    }
}