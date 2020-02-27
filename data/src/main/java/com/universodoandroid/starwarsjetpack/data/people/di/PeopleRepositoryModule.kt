package com.universodoandroid.starwarsjetpack.data.people.di

import com.universodoandroid.starwarsjetpack.data.people.mappers.PeopleDataMapper
import com.universodoandroid.starwarsjetpack.data.people.mappers.PeopleMapper
import com.universodoandroid.starwarsjetpack.data.people.mappers.PeoplePageMapper
import com.universodoandroid.starwarsjetpack.data.people.repository.PeopleRepositoryImpl
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import com.universodoandroid.starwarsjetpack.shared.extensions.getMapper
import com.universodoandroid.starwarsjetpack.shared.extensions.mapper
import org.koin.dsl.module

internal fun getPeopleRepositoryModule() = module {
    mapper { PeopleMapper() }
    mapper { PeopleDataMapper() }
    mapper { PeoplePageMapper(getMapper()) }

    factory<PeopleRepository> {
        PeopleRepositoryImpl(get(), get(), get(), getMapper(), getMapper(), getMapper())
    }
}