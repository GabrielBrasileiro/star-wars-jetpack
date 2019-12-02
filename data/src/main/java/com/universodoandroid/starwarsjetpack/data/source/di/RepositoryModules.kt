package com.universodoandroid.starwarsjetpack.data.source.di

import com.universodoandroid.starwarsjetpack.data.source.people.getPeopleRepositoryModule

fun getRepositoryModules() = listOf(
    getPeopleRepositoryModule()
)