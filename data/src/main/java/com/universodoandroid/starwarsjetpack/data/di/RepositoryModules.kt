package com.universodoandroid.starwarsjetpack.data.di

import com.universodoandroid.starwarsjetpack.data.people.di.getPeopleRepositoryModule

fun getRepositoryModules() = listOf(
    getPeopleRepositoryModule()
)