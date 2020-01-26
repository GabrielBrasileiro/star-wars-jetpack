package com.universodoandroid.starwarsjetpack.data.people.source

import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import org.koin.dsl.module


private val repository = module {
    single<PeopleRepository> {
        PeopleRepositoryImpl(
            get(),
            get(),
            get()
        )
    }
}

internal fun getPeopleRepositoryModule() =
    repository