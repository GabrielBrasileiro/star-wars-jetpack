package com.universodoandroid.starwarsjetpack.local.di

import com.universodoandroid.starwarsjetpack.local.AppDatabase
import com.universodoandroid.starwarsjetpack.local.database.people.di.getPeopleDatabaseModules
import org.koin.dsl.module

internal val appDatabase = module {
    single { AppDatabase.getDatabase(get()) }
}

fun getDatabaseModules() = listOf(
    appDatabase,
    getPeopleDatabaseModules()
)