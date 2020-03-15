package com.universodoandroid.starwarsjetpack.domain.people.di

import com.nhaarman.mockitokotlin2.mock
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.test.check.checkModules

class PeopleUseCaseModulesTest {

    private val peopleRepository = mock<PeopleRepository>()

    private val peopleDependencies = module {
        factory { peopleRepository }
    }

    @Test
    fun `getUseCaseModules should load people use case dependencies`() {
        koinApplication {
            modules(listOf(peopleDependencies) + getPeopleUseCaseModules())
        }.checkModules()
    }
}