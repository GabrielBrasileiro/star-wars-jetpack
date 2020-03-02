package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event

import androidx.lifecycle.LiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.Event

internal interface EventView<E : Event> {
    fun getEvent(): LiveData<E>
    fun setEvent(_event: E)
}