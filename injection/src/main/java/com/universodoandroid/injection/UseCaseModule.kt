package com.universodoandroid.injection

import com.universodoandroid.remote.usecase.people.PeopleUseCase
import com.universodoandroid.remote.usecase.people.PeopleUseCaseImpl
import com.universodoandroid.remote.usecase.planet.PlanetUseCase
import com.universodoandroid.remote.usecase.planet.PlanetUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<PeopleUseCase>(createdAtStart = true) { PeopleUseCaseImpl(get()) }
    single<PlanetUseCase>(createdAtStart = false) { PlanetUseCaseImpl() }
}