package com.universodoandroid.starwarsjetpack.data.database.people.di

import com.universodoandroid.starwarsjetpack.data.database.people.PeopleDatabase
import com.universodoandroid.starwarsjetpack.data.database.people.PeopleDatabaseImpl
import org.koin.dsl.module

private val peopleDatabaseModules = module {
    single<PeopleDatabase> { PeopleDatabaseImpl(get()) }
}

internal fun getPeopleDatabaseModules() = peopleDatabaseModules