package com.universodoandroid.starwarsjetpack.data.database.di

import com.universodoandroid.starwarsjetpack.data.database.people.di.getPeopleDatabaseModules

fun getDatabaseModules() = listOf(
    getPeopleDatabaseModules()
)