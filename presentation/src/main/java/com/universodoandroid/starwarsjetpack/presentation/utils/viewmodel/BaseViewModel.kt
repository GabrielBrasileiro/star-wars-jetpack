package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.Event
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.EventView
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.Reducer
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.StateEvent
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.State
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.StateView

abstract class BaseViewModel<S : State, E : Event, SE : StateEvent>(
    private val event: MutableLiveData<E>,
    private val reducer: Reducer<S, SE>
) : ObservableViewModel(), EventView<E>, StateView<S> {

    protected fun setEvent(_event: E) {
        event.value = _event
    }

    protected fun updateTo(eventState: SE) {
        reducer.updateTo(eventState)
    }

    override fun getState(): LiveData<S> = reducer.getState()

    override fun getEvent(): LiveData<E> = event

}

