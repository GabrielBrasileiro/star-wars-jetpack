package com.universodoandroid.starwarsjetpack.presentation.people.di

import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PeoplePresentationMapper
import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PersonDetailsPresentationMapper
import com.universodoandroid.starwarsjetpack.presentation.people.models.people.PeopleListViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.models.person.PersonDetailsViewModel
import com.universodoandroid.starwarsjetpack.shared.mapper.getMapper
import com.universodoandroid.starwarsjetpack.shared.mapper.mapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getPeopleViewModelModules() = module {
    mapper { PeoplePresentationMapper() }
    mapper { PersonDetailsPresentationMapper() }

    viewModel { PeopleListViewModel(get(), getMapper()) }
    viewModel { PersonDetailsViewModel(get(), getMapper()) }
}