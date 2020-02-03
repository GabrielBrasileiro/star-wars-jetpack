package com.universodoandroid.starwarsjetpack.remote.di

import com.universodoandroid.starwarsjetpack.remote.BuildConfig
import com.universodoandroid.starwarsjetpack.remote.ApiDataSource
import com.universodoandroid.starwarsjetpack.remote.people.data.di.getPeopleRemoteModules
import org.koin.dsl.module

internal val apiDataSource = module {
    single { ApiDataSource(BuildConfig.BASE_URL) }
}

fun getRemoteModules() = listOf(
    apiDataSource,
    getPeopleRemoteModules()
)