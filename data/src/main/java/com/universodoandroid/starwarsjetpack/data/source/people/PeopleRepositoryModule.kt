package com.universodoandroid.starwarsjetpack.data.source.people

import com.universodoandroid.starwarsjetpack.domain.repositories.PeopleRepository
import org.koin.dsl.module


private val repository = module {
    single<PeopleRepository> {
        PeopleRepositoryImpl(get(), get(), get())
    }
}

internal fun getPeopleRepositoryModule() = repository