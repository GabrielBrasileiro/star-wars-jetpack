package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.ObservableViewModel

open class EventViewModel<E : Event>(
    private val event: MutableLiveData<E>
) : EventView<E>, ObservableViewModel() {

    override fun getEvent(): LiveData<E> = event

    protected fun setEvent(_event: E) {
        event.value = _event
    }
}
