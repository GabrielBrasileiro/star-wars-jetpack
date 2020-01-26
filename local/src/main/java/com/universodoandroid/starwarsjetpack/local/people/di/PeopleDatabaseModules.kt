package com.universodoandroid.starwarsjetpack.local.people.di

import com.universodoandroid.starwarsjetpack.data.people.datastore.people.PeopleLocalData
import com.universodoandroid.starwarsjetpack.local.people.PeopleLocalDataImpl
import com.universodoandroid.starwarsjetpack.local.people.database.PeopleDatabase
import com.universodoandroid.starwarsjetpack.local.people.database.PeopleDatabaseImpl
import org.koin.dsl.module

private val peopleDatabaseModules = module {
    factory<PeopleDatabase> { PeopleDatabaseImpl(get()) }
    factory<PeopleLocalData> { PeopleLocalDataImpl(get()) }
}

internal fun getPeopleDatabaseModules() = peopleDatabaseModules