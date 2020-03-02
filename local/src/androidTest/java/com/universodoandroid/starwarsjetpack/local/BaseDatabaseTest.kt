package com.universodoandroid.starwarsjetpack.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class BaseDatabaseTest {

    protected lateinit var appDatabase: AppDatabase

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun initDatabase() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context, AppDatabase::class.java
        ).build()
    }

    @After
    fun closeDatabase() {
        appDatabase.close()
    }
}
