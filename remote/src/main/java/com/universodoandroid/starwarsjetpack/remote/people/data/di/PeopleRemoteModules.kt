package com.universodoandroid.starwarsjetpack.remote.people.data.di

import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.remote.ApiDataSource
import com.universodoandroid.starwarsjetpack.remote.people.api.PeopleApiDataSource
import com.universodoandroid.starwarsjetpack.remote.people.data.PeopleRemoteDataSource
import com.universodoandroid.starwarsjetpack.remote.people.data.PeopleRemoteDataSourceImpl
import com.universodoandroid.starwarsjetpack.remote.people.source.PeopleRemoteDataImpl
import org.koin.dsl.module

private val remoteModules = module {
    factory { get<ApiDataSource>().createService(PeopleApiDataSource::class.java) }
    factory<PeopleRemoteDataSource> { PeopleRemoteDataSourceImpl(get()) }
    factory<PeopleRemoteData> { PeopleRemoteDataImpl(get()) }
}

internal fun getPeopleRemoteModules() = remoteModules