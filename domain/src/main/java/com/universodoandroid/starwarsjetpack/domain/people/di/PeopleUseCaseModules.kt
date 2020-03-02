package com.universodoandroid.starwarsjetpack.domain.people.di

import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import org.koin.dsl.module

internal val useCaseModules = module {
    factory { GetPeopleUseCase(get()) }
    factory { GetPersonUseCase(get()) }
}

internal fun getPeopleUseCaseModules() = useCaseModules