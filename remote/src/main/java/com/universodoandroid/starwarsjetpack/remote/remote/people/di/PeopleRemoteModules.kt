package com.universodoandroid.starwarsjetpack.remote.remote.people.di

import com.universodoandroid.starwarsjetpack.data.common.di.DIContext
import com.universodoandroid.starwarsjetpack.remote.api.ApiDataSource
import com.universodoandroid.starwarsjetpack.remote.api.PeopleApiDataSource
import com.universodoandroid.starwarsjetpack.remote.remote.people.PeopleRemoteDataSource
import com.universodoandroid.starwarsjetpack.remote.remote.people.PeopleRemoteDataSourceImpl
import com.universodoandroid.starwarsjetpack.remote.source.PeopleRemoteImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

private val remoteModules = module {
    factory { get<ApiDataSource>().createService(PeopleApiDataSource::class.java) }
    factory<PeopleRemoteDataSource> { PeopleRemoteDataSourceImpl(get()) }
    factory(named(DIContext.REMOTE)) { PeopleRemoteImpl(get()) }
}

internal fun getPeopleRemoteModules() = remoteModules