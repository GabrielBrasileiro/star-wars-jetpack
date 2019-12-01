package com.universodoandroid.starwarsjetpack.remote.remote.people.di

import com.universodoandroid.starwarsjetpack.remote.api.ApiDataSource
import com.universodoandroid.starwarsjetpack.remote.api.PeopleApiDataSource
import com.universodoandroid.starwarsjetpack.remote.remote.people.PeopleRemoteDataSource
import com.universodoandroid.starwarsjetpack.remote.remote.people.PeopleRemoteDataSourceImpl
import org.koin.dsl.module

private val remoteModules = module {
    factory { get<ApiDataSource>().createService(PeopleApiDataSource::class.java) }
    factory<PeopleRemoteDataSource> { PeopleRemoteDataSourceImpl(get()) }
}

internal fun getPeopleRemoteModules() = remoteModules