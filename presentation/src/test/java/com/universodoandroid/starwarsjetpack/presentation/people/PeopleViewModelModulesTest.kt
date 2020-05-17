package com.universodoandroid.starwarsjetpack.presentation.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.di.getPeopleViewModelModules
import org.junit.Rule
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.test.check.checkModules

class PeopleViewModelModulesTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()


    private val peopleUseCase = mock<GetPeopleUseCase>()
    private val personUseCase = mock<GetPersonUseCase>()

    private val modules = module {
        factory { peopleUseCase }
        factory { personUseCase }
    }

    @Test
    fun `getPeopleViewModelModules should load all people view models`() {
        koinApplication {
            modules(listOf(modules, getPeopleViewModelModules()))
        }.checkModules()
    }
}