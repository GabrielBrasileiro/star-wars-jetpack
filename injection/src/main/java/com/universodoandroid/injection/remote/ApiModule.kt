package com.universodoandroid.injection.remote

import com.universodoandroid.remote.BuildConfig
import com.universodoandroid.remote.api.ApiDataSource
import com.universodoandroid.remote.api.PeopleApiDataSource
import com.universodoandroid.remote.api.PlanetApiDataSource
import org.koin.dsl.module

val apiModule = module {
    single { ApiDataSource(BuildConfig.BASE_URL) }

    single(createdAtStart = true) { get<ApiDataSource>().createService(PeopleApiDataSource::class.java) }
    single(createdAtStart = false) { get<ApiDataSource>().createService(PlanetApiDataSource::class.java) }
}