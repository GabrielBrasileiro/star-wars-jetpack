package com.universodoandroid.starwarsjetpack.di

import com.universodoandroid.starwarsjetpack.domain.common.executors.PostExecutorThread
import com.universodoandroid.starwarsjetpack.domain.session.CacheManager
import com.universodoandroid.starwarsjetpack.presentation.executor.UIThread
import com.universodoandroid.starwarsjetpack.session.CacheManagerImpl
import org.koin.dsl.module

internal val globalDependencies = module {
    single<CacheManager> { CacheManagerImpl(get()) }
    factory<PostExecutorThread> { UIThread() }
}


fun getGlobalDependencies() = listOf(globalDependencies)