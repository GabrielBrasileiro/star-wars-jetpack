package com.universodoandroid.local.local

import android.content.Context
import com.universodoandroid.local.AppDatabase
import com.universodoandroid.local.local.person.PersonRepository
import com.universodoandroid.local.local.person.PersonRepositoryImpl

object InjectionRepository {

    private fun provideDatabase(context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    fun providePeopleRepository(context: Context): PersonRepository {
        val personDatabase = provideDatabase(context).personDao()
        return PersonRepositoryImpl(personDatabase)
    }

}