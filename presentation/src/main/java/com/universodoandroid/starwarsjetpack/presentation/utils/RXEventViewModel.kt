package com.universodoandroid.starwarsjetpack.presentation.utils

import com.mvvmredux.core.event.Event
import com.mvvmredux.core.event.EventViewModel
import com.mvvmredux.core.livedata.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RXEventViewModel<E : Event>(event: SingleLiveEvent<E>) : EventViewModel<E>(event) {

    private val compositeDisposable by lazy { CompositeDisposable() }

    protected fun Disposable.pool() = apply { compositeDisposable.add(this) }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}