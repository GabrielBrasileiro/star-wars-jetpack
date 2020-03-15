package com.universodoandroid.starwarsjetpack.local.di

import android.content.Context
import android.content.SharedPreferences
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.test.check.checkModules

class DatabaseModulesTest {

    private val context = mock<Context>()
    private val applicationContext = mock<Context>()
    private val sharedPreferences = mock<SharedPreferences>()

    private val modules = module {
        single { context }
    }

    @Before
    fun setup() {
        whenever(context.applicationContext).thenReturn(applicationContext)
        whenever(context.getSharedPreferences(any(), any())).thenReturn(sharedPreferences)
    }

    @Test
    fun `app database should return all local dependencies`() {
        koinApplication {
            modules(
                listOf(modules) + getDatabaseModules()
            )
        }.checkModules()
    }
}
