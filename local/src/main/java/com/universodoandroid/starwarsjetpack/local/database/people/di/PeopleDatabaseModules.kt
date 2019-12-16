package com.universodoandroid.starwarsjetpack.local.database.people.di

import com.universodoandroid.starwarsjetpack.data.datastore.people.PeopleLocalData
import com.universodoandroid.starwarsjetpack.local.database.people.PeopleDatabase
import com.universodoandroid.starwarsjetpack.local.database.people.PeopleDatabaseImpl
import com.universodoandroid.starwarsjetpack.local.source.PeopleLocalDataImpl
import org.koin.dsl.module

private val peopleDatabaseModules = module {
    single<PeopleDatabase> { PeopleDatabaseImpl(get()) }
    single<PeopleLocalData> { PeopleLocalDataImpl(get()) }
}

internal fun getPeopleDatabaseModules() = peopleDatabaseModules