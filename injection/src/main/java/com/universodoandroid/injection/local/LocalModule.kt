package com.universodoandroid.injection.local

import com.universodoandroid.domain.repository.PersonRepository
import com.universodoandroid.local.local.person.PersonRepositoryImpl
import org.koin.dsl.module


val localModule = module {
    single<com.universodoandroid.domain.repository.PersonRepository> { PersonRepositoryImpl(get()) }
}