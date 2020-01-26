package com.universodoandroid.starwarsjetpack.domain.di

import com.universodoandroid.starwarsjetpack.domain.people.di.getPeopleUseCaseModules

fun getUseCaseModules() = listOf(
    getPeopleUseCaseModules()
)