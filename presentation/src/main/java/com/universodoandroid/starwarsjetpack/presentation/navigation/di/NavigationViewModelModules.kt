package com.universodoandroid.starwarsjetpack.presentation.navigation.di

import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getNavigationModules() = module {
    viewModel { NavigationViewModel() }
}