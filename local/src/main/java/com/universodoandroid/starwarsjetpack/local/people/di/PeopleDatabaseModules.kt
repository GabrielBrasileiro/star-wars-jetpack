package com.universodoandroid.starwarsjetpack.local.people.di

import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleLocalData
import com.universodoandroid.starwarsjetpack.local.AppDatabase
import com.universodoandroid.starwarsjetpack.local.people.data.PeopleLocalDataImpl
import com.universodoandroid.starwarsjetpack.local.people.database.PeopleDatabase
import com.universodoandroid.starwarsjetpack.local.people.database.PeopleDatabaseImpl
import com.universodoandroid.starwarsjetpack.local.people.mapper.PersonDataMapper
import com.universodoandroid.starwarsjetpack.local.people.mapper.PersonEntityMapper
import com.universodoandroid.starwarsjetpack.shared.extensions.getMapper
import com.universodoandroid.starwarsjetpack.shared.extensions.mapper
import org.koin.dsl.module

internal fun getPeopleDatabaseModules() = module {
    mapper { PersonDataMapper() }
    mapper { PersonEntityMapper() }

    factory { get<AppDatabase>().personDao() }
    factory<PeopleDatabase> { PeopleDatabaseImpl(get()) }
    factory<PeopleLocalData> { PeopleLocalDataImpl(get(), get(), getMapper(), getMapper()) }
}
