package com.universodoandroid.starwarsjetpack.local.di

import android.content.Context
import android.content.SharedPreferences
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeoplePreferences
import com.universodoandroid.starwarsjetpack.local.AppDatabase
import com.universodoandroid.starwarsjetpack.local.people.di.getPeopleDatabaseModules
import com.universodoandroid.starwarsjetpack.local.prefs.PeoplePreferencesImpl
import org.koin.dsl.module

internal val appDatabase = module {
    single { AppDatabase.getDatabase(get()) }
}

internal val preferences = module {
    factory<PeoplePreferences> { PeoplePreferencesImpl(get()) }
    factory<SharedPreferences> {
        get<Context>().getSharedPreferences(prefsName, Context.MODE_PRIVATE)
    }
}

internal const val prefsName = "data_manager"

fun getDatabaseModules() = listOf(
    appDatabase,
    preferences,
    getPeopleDatabaseModules()
)