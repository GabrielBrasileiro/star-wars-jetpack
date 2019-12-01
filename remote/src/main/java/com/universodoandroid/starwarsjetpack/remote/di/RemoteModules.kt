package com.universodoandroid.starwarsjetpack.remote.di

import com.universodoandroid.starwarsjetpack.remote.remote.people.di.getPeopleRemoteModules

fun getRemoteModules() = listOf(
    getPeopleRemoteModules()
)