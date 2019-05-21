package com.universodoandroid.remote.usecase

import android.app.Application
import com.universodoandroid.remote.usecase.people.PeopleUseCase

object InjectionUseCase {

    fun providePeopleUseCase(application: Application): PeopleUseCase {
        return PeopleUseCase(application)
    }

}