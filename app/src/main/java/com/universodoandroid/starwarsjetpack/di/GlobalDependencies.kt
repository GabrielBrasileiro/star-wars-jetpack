package com.universodoandroid.starwarsjetpack.di

import com.universodoandroid.starwarsjetpack.domain.executors.PostExecutorThread
import com.universodoandroid.starwarsjetpack.domain.session.CacheData
import com.universodoandroid.starwarsjetpack.presentation.executor.UIThread
import com.universodoandroid.starwarsjetpack.session.CacheDataImpl
import org.koin.dsl.module

internal val globalDependencies = module {
    single<CacheData> { CacheDataImpl(get()) }
    factory<PostExecutorThread> { UIThread() }
}


fun getGlobalDependencies() = listOf(globalDependencies)