package com.universodoandroid.starwarsjetpack.presentation.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.data.PeopleMock
import com.universodoandroid.starwarsjetpack.presentation.people.di.getPeopleViewModelModules
import io.reactivex.Single
import org.junit.Before
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

    @Before
    fun setup() {
        whenever(peopleUseCase.getPeople()).thenReturn(Single.just(listOf()))
    }

    @Test
    fun `getPeopleViewModelModules should load all people view models`() {
        koinApplication {
            modules(listOf(modules, getPeopleViewModelModules()))
        }.checkModules()
    }
}