package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event

import androidx.lifecycle.LiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.Event

interface EventView<E : Event> {
    fun getEvent(): LiveData<E>
}