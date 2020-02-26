package com.universodoandroid.starwarsjetpack.data.people.di

import com.universodoandroid.starwarsjetpack.data.people.repository.PeopleRepositoryImpl
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import org.koin.dsl.module

internal fun getPeopleRepositoryModule() = module {
    single<PeopleRepository> {
        PeopleRepositoryImpl(
            get(),
            get(),
            get()
        )
    }
}