package com.universodoandroid.starwarsjetpack.data.source.people

import com.universodoandroid.starwarsjetpack.data.common.di.DIContext
import com.universodoandroid.starwarsjetpack.domain.repositories.PeopleRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module


private val repository = module {
    single<PeopleRepository> {
        PeopleRepositoryImpl(
            remote = get(named(DIContext.REMOTE)),
            local = get(named(DIContext.LOCAL))
        )
    }
}

internal fun getPeopleRepositoryModule() = repository