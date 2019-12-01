package com.universodoandroid.starwarsjetpack.data.database.di

import com.universodoandroid.starwarsjetpack.data.AppDatabase
import com.universodoandroid.starwarsjetpack.data.database.people.di.getPeopleDatabaseModules
import org.koin.dsl.module

internal val appDatabase = module {
    single { AppDatabase.getDatabase(get()) }
}

fun getDatabaseModules() = listOf(
    appDatabase,
    getPeopleDatabaseModules()
)