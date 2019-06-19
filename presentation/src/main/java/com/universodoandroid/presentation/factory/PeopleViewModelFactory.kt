package com.universodoandroid.presentation.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.universodoandroid.presentation.models.PeopleListViewModel

class PeopleViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(PeopleListViewModel::class.java) -> PeopleListViewModel(application)
                else -> throw IllegalArgumentException("Unknown class")
            } as T
        }
    }

}