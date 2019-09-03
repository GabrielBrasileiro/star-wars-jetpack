package com.universodoandroid.remote.usecase

import android.app.Application
import com.universodoandroid.remote.usecase.people.PeopleUseCase
import com.universodoandroid.remote.usecase.people.PeopleUseCaseImpl

object InjectionUseCase {

    fun providePeopleUseCase(application: Application): PeopleUseCase {
        return PeopleUseCaseImpl(application)
    }

}