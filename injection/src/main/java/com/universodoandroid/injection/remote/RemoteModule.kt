package com.universodoandroid.injection.remote

import com.universodoandroid.remote.remote.people.PeopleRemoteDataSource
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSourceImpl
import org.koin.dsl.module


val remoteModule = module {
    single<PeopleRemoteDataSource> { PeopleRemoteDataSourceImpl(get()) }
}