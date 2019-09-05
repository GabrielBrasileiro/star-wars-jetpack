package com.universodoandroid.injection.local

import com.universodoandroid.local.local.person.PersonRepository
import com.universodoandroid.local.local.person.PersonRepositoryImpl
import org.koin.dsl.module


val localModule = module {
    single<PersonRepository> { PersonRepositoryImpl(get()) }
}