package com.universodoandroid.starwarsjetpack.presentation.di

import com.universodoandroid.starwarsjetpack.presentation.people.di.getPeopleViewModelModules

fun getViewModelsModules() = listOf(
    getPeopleViewModelModules()
)