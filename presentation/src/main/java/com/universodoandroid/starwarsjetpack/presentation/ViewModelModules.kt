package com.universodoandroid.starwarsjetpack.presentation

import com.universodoandroid.starwarsjetpack.presentation.people.di.getPeopleViewModelModules

fun getViewModelsModules() = listOf(
    getPeopleViewModelModules()
)