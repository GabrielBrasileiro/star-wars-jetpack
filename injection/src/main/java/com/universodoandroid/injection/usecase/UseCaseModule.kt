package com.universodoandroid.injection.usecase

import com.universodoandroid.domain.usecase.people.PeopleUseCase
import com.universodoandroid.domain.usecase.people.PeopleUseCaseImpl
import com.universodoandroid.domain.usecase.planet.PlanetUseCase
import com.universodoandroid.domain.usecase.planet.PlanetUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<PeopleUseCase>(createdAtStart = true) { PeopleUseCaseImpl(get()) }
    single<PlanetUseCase>(createdAtStart = false) { PlanetUseCaseImpl() }
}