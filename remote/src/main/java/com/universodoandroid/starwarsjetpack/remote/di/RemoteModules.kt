package com.universodoandroid.starwarsjetpack.remote.di

import com.universodoandroid.starwarsjetpack.remote.BuildConfig
import com.universodoandroid.starwarsjetpack.remote.api.ApiDataSource
import com.universodoandroid.starwarsjetpack.remote.remote.people.di.getPeopleRemoteModules
import org.koin.dsl.module

internal val apiDataSource = module {
    single { ApiDataSource(BuildConfig.BASE_URL) }
}

fun getRemoteModules() = listOf(
    apiDataSource,
    getPeopleRemoteModules()
)