package com.universodoandroid.starwarsjetpack.remote.people

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.universodoandroid.starwarsjetpack.remote.people.api.PeopleApi
import com.universodoandroid.starwarsjetpack.remote.people.di.getPeopleRemoteModules
import com.universodoandroid.starwarsjetpack.remote.source.ApiDataSource
import org.junit.Before
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.test.check.checkModules

class PeopleRemoteModulesTest {

    private val apiDataSource = mock<ApiDataSource>()
    private val peopleApi = mock<PeopleApi>()

    private val modules = module {
        single { apiDataSource }
    }

    @Before
    fun setup() {
        whenever(apiDataSource.createService(PeopleApi::class.java)).thenReturn(peopleApi)
    }

    @Test
    fun `people database should Provide People Database Dependencies`() {
        koinApplication {
            modules(
                listOf(
                    modules,
                    getPeopleRemoteModules()
                )
            )
        }.checkModules()
    }
}