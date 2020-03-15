package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.Event
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.State
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.EventView
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.StateView

open class BaseViewModel<E : Event, S: State>: EventView<E>, StateView<S>, ObservableViewModel() {

    private var event: MutableLiveData<E> = MutableLiveData()

    private var state: MutableLiveData<S> = MutableLiveData()

    override fun getEvent(): LiveData<E> = event

    override fun getState(): LiveData<S> = state

    protected fun setEvent(_event: E) {
        event.value = _event
    }

    protected fun setState(_state: S) {
        state.value = _state
    }
}
