package com.universodoandroid.starwarsjetpack.data.repositories.di

import com.universodoandroid.starwarsjetpack.data.repositories.people.di.getPeopleRepositoriesModule

fun getRepositoriesModules() = listOf(
    getPeopleRepositoriesModule()
)