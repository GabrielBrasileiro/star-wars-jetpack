package com.universodoandroid.starwarsjetpack.remote.remote.people.di

import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.remote.api.ApiDataSource
import com.universodoandroid.starwarsjetpack.remote.api.PeopleApiDataSource
import com.universodoandroid.starwarsjetpack.remote.remote.people.PeopleRemoteDataSource
import com.universodoandroid.starwarsjetpack.remote.remote.people.PeopleRemoteDataSourceImpl
import com.universodoandroid.starwarsjetpack.remote.source.PeopleRemoteDataImpl
import org.koin.dsl.module

private val remoteModules = module {
    factory { get<ApiDataSource>().createService(PeopleApiDataSource::class.java) }
    factory<PeopleRemoteDataSource> { PeopleRemoteDataSourceImpl(get()) }
    factory<PeopleRemoteData> { PeopleRemoteDataImpl(get()) }
}

internal fun getPeopleRemoteModules() = remoteModules