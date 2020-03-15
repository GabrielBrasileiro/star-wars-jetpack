package com.universodoandroid.starwarsjetpack.presentation.navigation

import com.universodoandroid.starwarsjetpack.presentation.navigation.di.getNavigationModules
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.check.checkModules

class NavigationViewModelModuleTest {

    @Test
    fun `getNavigationModules should load navigation view models`() {
        koinApplication {
            modules(getNavigationModules())
        }.checkModules()
    }
}