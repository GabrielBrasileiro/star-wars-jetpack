package com.universodoandroid.starwarsjetpack.remote.people.di

import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.remote.people.api.PeopleApi
import com.universodoandroid.starwarsjetpack.remote.people.data.PeopleRemoteDataImpl
import com.universodoandroid.starwarsjetpack.remote.people.mapper.PersonPageDataMapper
import com.universodoandroid.starwarsjetpack.remote.people.remote.PeopleRemoteDataSource
import com.universodoandroid.starwarsjetpack.remote.people.remote.PeopleRemoteDataSourceImpl
import com.universodoandroid.starwarsjetpack.remote.source.ApiDataSource
import com.universodoandroid.starwarsjetpack.shared.extensions.getMapper
import com.universodoandroid.starwarsjetpack.shared.extensions.mapper
import org.koin.dsl.module

internal fun getPeopleRemoteModules() = module {
    mapper { PersonPageDataMapper() }

    factory { get<ApiDataSource>().createService(PeopleApi::class.java) }
    factory<PeopleRemoteDataSource> { PeopleRemoteDataSourceImpl(get()) }
    factory<PeopleRemoteData> { PeopleRemoteDataImpl(get(), getMapper()) }
}
