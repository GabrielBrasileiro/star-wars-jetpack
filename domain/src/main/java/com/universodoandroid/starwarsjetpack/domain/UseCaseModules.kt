package com.universodoandroid.starwarsjetpack.domain

import com.universodoandroid.starwarsjetpack.domain.usecase.people.di.getPeopleUseCaseModules

fun getUseCaseModules() = listOf(
    getPeopleUseCaseModules()
)