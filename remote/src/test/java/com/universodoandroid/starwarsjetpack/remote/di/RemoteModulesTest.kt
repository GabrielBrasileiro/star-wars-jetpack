package com.universodoandroid.starwarsjetpack.remote.di

import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.check.checkModules

class RemoteModulesTest {

    @Test
    fun `app database should return all local dependencies`() {
        koinApplication {
            modules(getRemoteModules())
        }.checkModules()
    }
}