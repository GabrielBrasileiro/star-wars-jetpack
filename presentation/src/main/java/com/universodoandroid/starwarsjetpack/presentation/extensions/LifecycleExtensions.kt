package com.universodoandroid.starwarsjetpack.presentation.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.Event
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.State
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.EventView
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.StateView

fun <E : Event> LifecycleOwner.onEvent(viewModel: EventView<E>, onEvent: (E) -> Unit) {
    viewModel.getEvent().observe(this, onEvent)
}

fun <S : State> LifecycleOwner.onStateChanged(viewModel: StateView<S>, onChange: (S) -> Unit) {
    viewModel.getState().observe(this, onChange)
}

private fun <O> LiveData<O>.observe(owner: LifecycleOwner, data: (O) -> Unit) {
    observe(owner, Observer { data(it) })
}
