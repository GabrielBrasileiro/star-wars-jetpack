package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.State

abstract class Reducer<S : State, SE : StateEvent>(
    private val mutableLiveData: MutableLiveData<S> = MutableLiveData<S>(), initialState: S
) {

    private val state = MutableLiveData<S>()

    init {
        state.value = initialState
    }

    abstract fun updateTo(stateAction: SE)

    protected fun updateState(update: S.() -> S) {
        val currentState = requireNotNull(state.value)
        state.value = update(currentState)
    }

    fun getState(): LiveData<S> = state
}
