package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.Event
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.EventView
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.Reducer
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.StateEvent
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.State
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.StateView

abstract class BaseViewModel<S : State, E : Event>(
    private val reducer: Reducer<S, *>
) : ObservableViewModel(), EventView<E>, StateView<S> {

    private val event: MutableLiveData<E> = MutableLiveData()

    protected fun setEvent(_event: E) {
        event.value = _event
    }

    override fun getState(): LiveData<S> = reducer.getState()

    override fun getEvent(): LiveData<E> = event
}

