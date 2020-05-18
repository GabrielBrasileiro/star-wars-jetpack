package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class ObservableViewModel : ViewModel() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    protected fun Disposable.pool() = apply { compositeDisposable.add(this) }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}