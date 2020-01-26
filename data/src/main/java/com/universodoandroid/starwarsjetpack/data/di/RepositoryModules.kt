package com.universodoandroid.starwarsjetpack.data.di

import com.universodoandroid.starwarsjetpack.data.people.source.getPeopleRepositoryModule

fun getRepositoryModules() = listOf(
    getPeopleRepositoryModule()
)