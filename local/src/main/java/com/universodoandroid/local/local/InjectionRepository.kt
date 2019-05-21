package com.universodoandroid.local.local

import android.app.Application
import com.universodoandroid.local.AppDatabase
import com.universodoandroid.local.local.person.PersonRepository
import com.universodoandroid.local.local.person.PersonRepositoryImpl

object InjectionRepository {

    private fun provideDatabase(application: Application): AppDatabase {
        return AppDatabase.getDatabase(application)
    }

    fun providePeopleRepository(application: Application): PersonRepository {
        val personDatabase = provideDatabase(application).personDao()
        return PersonRepositoryImpl(personDatabase)
    }

}