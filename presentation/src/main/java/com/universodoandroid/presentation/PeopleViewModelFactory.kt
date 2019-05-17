package com.universodoandroid.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.universodoandroid.presentation.models.PeopleListViewModel

class PeopleViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(PeopleListViewModel::class.java) -> PeopleListViewModel()
                else -> throw IllegalArgumentException("Unknown class")
            } as T
        }
    }

}