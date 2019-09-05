package com.universodoandroid.injection.viewmodel

import com.universodoandroid.presentation.models.PeopleListViewModel
import com.universodoandroid.presentation.models.PersonDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PeopleListViewModel(get()) }
    viewModel { PersonDetailsViewModel(get()) }
}
