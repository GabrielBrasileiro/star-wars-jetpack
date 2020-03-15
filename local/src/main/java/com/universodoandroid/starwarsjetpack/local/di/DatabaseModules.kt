package com.universodoandroid.starwarsjetpack.local.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.universodoandroid.starwarsjetpack.local.AppDatabase
import com.universodoandroid.starwarsjetpack.local.people.di.getPeopleDatabaseModules
import com.universodoandroid.starwarsjetpack.local.cache.CachePreferences
import com.universodoandroid.starwarsjetpack.local.cache.CachePreferencesImpl
import org.koin.dsl.module


private const val DATABASE_NAME = "star_wars_database"
internal const val PREFERENCES_NAME = "data_manager"

internal val appDatabase = module {
    single {
        Room.databaseBuilder(
            get<Context>().applicationContext, AppDatabase::class.java, DATABASE_NAME
        ).build()
    }
}

internal val preferences = module {
    factory<CachePreferences> { CachePreferencesImpl(get()) }
    factory<SharedPreferences> {
        get<Context>().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}

fun getDatabaseModules() = listOf(
    appDatabase,
    preferences,
    getPeopleDatabaseModules()
)