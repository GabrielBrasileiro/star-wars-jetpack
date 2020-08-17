package com.universodoandroid.starwarsjetpack.presentation.navigation.di

import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationViewModel
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.reducer.NavigationReducer
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getNavigationModules() = module {
    viewModel { NavigationViewModel(NavigationReducer()) }
}