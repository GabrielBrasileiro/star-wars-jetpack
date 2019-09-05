package com.universodoandroid.injection.local

import com.universodoandroid.local.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { AppDatabase.getDatabase(get()) }

    single { get<AppDatabase>().personDao() }
}