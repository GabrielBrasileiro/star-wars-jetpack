package com.universodoandroid.starwarsjetpack.presentation.utils

import com.mvvmredux.core.BaseViewModel
import com.mvvmredux.core.event.Event
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.core.state.State
import com.mvvmredux.core.stateevent.StateEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RXBaseViewModel<S : State, E : Event, SE : StateEvent>(
    event: SingleLiveEvent<E>, reducer: Reducer<S, SE>
) : BaseViewModel<S, E, SE>(event, reducer) {

    private val compositeDisposable by lazy { CompositeDisposable() }

    protected fun Disposable.pool() = apply { compositeDisposable.add(this) }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
