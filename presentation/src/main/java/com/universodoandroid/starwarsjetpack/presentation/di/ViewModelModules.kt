package com.universodoandroid.starwarsjetpack.presentation.di

import com.universodoandroid.starwarsjetpack.presentation.navigation.di.getNavigationModules
import com.universodoandroid.starwarsjetpack.presentation.people.di.getPeopleViewModelModules

fun getViewModelsModules() = listOf(
    getNavigationModules(),
    getPeopleViewModelModules()
)