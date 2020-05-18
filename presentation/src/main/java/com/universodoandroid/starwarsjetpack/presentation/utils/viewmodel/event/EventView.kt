package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event

import androidx.lifecycle.LiveData

interface EventView<E : Event> {
    fun getEvent(): LiveData<E>
}
