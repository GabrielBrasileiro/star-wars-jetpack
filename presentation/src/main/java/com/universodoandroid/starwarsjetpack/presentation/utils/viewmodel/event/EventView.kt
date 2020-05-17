package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event

import androidx.lifecycle.LiveData

interface EventView<out E : Event> {
    fun getEvent(): LiveData<out E>
}
