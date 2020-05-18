package com.universodoandroid.starwarsjetpack.presentation.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.Event
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.EventView
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.State
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.StateView

inline fun <E : Event> LifecycleOwner.onEventChanged(
    viewModel: EventView<E>,
    crossinline onEvent: (E) -> Unit
) {
    viewModel.getEvent().observe(this, onEvent)
}

inline fun <S : State> LifecycleOwner.onStateChanged(
    viewModel: StateView<S>,
    crossinline onChange: (S) -> Unit
) {
    viewModel.getState().observe(this, onChange)
}

inline fun <O> LiveData<O>.observe(owner: LifecycleOwner, crossinline data: (O) -> Unit) {
    observe(owner, Observer { data(it) })
}
