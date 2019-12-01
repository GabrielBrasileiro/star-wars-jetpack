package com.universodoandroid.starwarsjetpack.presentation

import com.universodoandroid.starwarsjetpack.presentation.executor.UIThread
import com.universodoandroid.starwarsjetpack.presentation.models.PeopleListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val executorThread = module {
    single { UIThread() }
}

internal val viewModels = module {
    viewModel { PeopleListViewModel(get()) }
}

fun getViewModelsModules() = listOf(executorThread, viewModels)