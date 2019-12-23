package com.universodoandroid.starwarsjetpack.di

import com.universodoandroid.starwarsjetpack.domain.session.CacheData
import com.universodoandroid.starwarsjetpack.session.CacheDataImpl
import org.koin.dsl.module

internal val globalDependencies = module {
    single<CacheData> { CacheDataImpl(get()) }
}


fun getGlobalDependencies() = listOf(globalDependencies)