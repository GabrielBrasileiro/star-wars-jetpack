package com.universodoandroid.starwarsjetpack.data.repositories.people.di

import com.universodoandroid.starwarsjetpack.data.repositories.people.PeopleCacheImpl
import com.universodoandroid.starwarsjetpack.data.repositories.people.PeopleRemoteImpl
import com.universodoandroid.starwarsjetpack.data.repositories.people.PeopleRepositoryImpl
import com.universodoandroid.starwarsjetpack.domain.common.di.DIContext
import com.universodoandroid.starwarsjetpack.domain.repository.PeopleRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module


private val repositories = module {
    single(named(DIContext.REMOTE)) { PeopleRemoteImpl(get()) }
    single(named(DIContext.LOCAL)) { PeopleCacheImpl(get()) }
    single<PeopleRepository> {
        PeopleRepositoryImpl(
            remote = get(named(DIContext.REMOTE)),
            local = get(named(DIContext.LOCAL))
        )
    }
}

internal fun getPeopleRepositoriesModule() = repositories