package com.universodoandroid.starwarsjetpack.remote.di

import com.universodoandroid.starwarsjetpack.remote.BuildConfig
import com.universodoandroid.starwarsjetpack.remote.people.di.getPeopleRemoteModules
import com.universodoandroid.starwarsjetpack.remote.source.ApiDataSource
import com.universodoandroid.starwarsjetpack.remote.source.ApiDataSourceImpl
import org.koin.dsl.module

internal val apiDataSource = module {
    single<ApiDataSource> { ApiDataSourceImpl(BuildConfig.BASE_URL) }
}

fun getRemoteModules() = listOf(
    apiDataSource,
    getPeopleRemoteModules()
)