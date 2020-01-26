package com.universodoandroid.starwarsjetpack.presentation

import com.universodoandroid.starwarsjetpack.presentation.people.models.person.PersonDetailsViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.models.people.PeopleListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModels = module {
    viewModel { PeopleListViewModel(get()) }
    viewModel {
        PersonDetailsViewModel(
            get()
        )
    }
}

fun getViewModelsModules() = listOf(viewModels)