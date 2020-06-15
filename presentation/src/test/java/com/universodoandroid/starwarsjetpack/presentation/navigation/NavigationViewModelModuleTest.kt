package com.universodoandroid.starwarsjetpack.presentation.navigation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.universodoandroid.starwarsjetpack.presentation.navigation.di.getNavigationModules
import org.junit.Rule
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.check.checkModules

class NavigationViewModelModuleTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `getNavigationModules should load navigation view models`() {
        koinApplication {
            modules(getNavigationModules())
        }.checkModules()
    }
}