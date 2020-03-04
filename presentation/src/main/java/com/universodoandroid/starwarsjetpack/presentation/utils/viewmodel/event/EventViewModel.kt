package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.Event
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.ObservableViewModel

open class EventViewModel<E : Event> : EventView<E>, ObservableViewModel() {

    private var event: MutableLiveData<E> = MutableLiveData()

    override fun getEvent(): LiveData<E> = event

    protected fun setEvent(_event: E) {
        event.value = _event
    }
}