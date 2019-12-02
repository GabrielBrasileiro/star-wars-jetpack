package com.universodoandroid.starwarsjetpack.domain.usecase.people.di

import com.universodoandroid.starwarsjetpack.domain.usecase.people.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.domain.usecase.people.GetPersonUseCase
import org.koin.dsl.module

internal val useCaseModules = module {
    factory { GetPeopleUseCase(get(), get(), get()) }
    factory { GetPersonUseCase(get(), get()) }
}

internal fun getPeopleUseCaseModules() = useCaseModules