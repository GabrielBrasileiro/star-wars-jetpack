package com.universodoandroid.starwarsjetpack.domain.usecase.people.di

import com.universodoandroid.starwarsjetpack.domain.usecase.people.GetFirstSyncPeopleUseCase
import org.koin.dsl.module

internal val useCaseModules = module {
    factory { GetFirstSyncPeopleUseCase(get(), get()) }
}

internal fun getPeopleUseCaseModules() = useCaseModules