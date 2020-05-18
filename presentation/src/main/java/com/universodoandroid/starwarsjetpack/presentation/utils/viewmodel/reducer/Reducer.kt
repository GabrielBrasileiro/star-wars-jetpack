package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.State

abstract class Reducer<S : State, SE : StateEvent>(initialState: S) {

    private val state = MutableLiveData<S>()

    init {
        state.value = initialState
    }

    abstract fun updateTo(stateEvent: SE)

    protected fun updateState(update: S.() -> S) {
        val currentState = requireNotNull(state.value)
        state.value = update(currentState)
    }

    fun getState(): LiveData<S> = state
}
