package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state

import androidx.lifecycle.LiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.ObservableViewModel
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.Reducer
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.StateEvent

open class StateViewModel<S : State, SE: StateEvent>(
    private val reducer: Reducer<S, SE>
) : StateView<S>, ObservableViewModel() {

    override fun getState(): LiveData<S> = reducer.getState()

    protected fun updateTo(eventState: SE) {
        reducer.updateTo(eventState)
    }
}
