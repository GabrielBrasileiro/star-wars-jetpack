package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class ObservableViewModel: LifecycleObserver, ViewModel() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    protected fun Disposable.pool() = apply { compositeDisposable.add(this) }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}