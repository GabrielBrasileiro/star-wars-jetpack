package com.universodoandroid.presentation.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.universodoandroid.presentation.models.PersonDetailsViewModel
import com.universodoandroid.remote.usecase.InjectionUseCase

class PersonDetailsViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val useCase = InjectionUseCase.providePeopleUseCase(application)
        return with(modelClass) {
            when {
                isAssignableFrom(PersonDetailsViewModel::class.java) -> PersonDetailsViewModel(useCase)
                else -> throw IllegalArgumentException("Unknown class")
            } as T
        }
    }

}