package com.universodoandroid.starwarsjetpack.local.database.people.di

import com.universodoandroid.starwarsjetpack.data.common.di.DIContext
import com.universodoandroid.starwarsjetpack.local.database.people.PeopleDatabase
import com.universodoandroid.starwarsjetpack.local.database.people.PeopleDatabaseImpl
import com.universodoandroid.starwarsjetpack.local.source.PeopleCacheImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

private val peopleDatabaseModules = module {
    single<PeopleDatabase> { PeopleDatabaseImpl(get()) }
    single(named(DIContext.LOCAL)) { PeopleCacheImpl(get()) }
}

internal fun getPeopleDatabaseModules() = peopleDatabaseModules