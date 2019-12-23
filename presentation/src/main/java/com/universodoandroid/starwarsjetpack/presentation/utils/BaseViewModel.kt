package com.universodoandroid.starwarsjetpack.presentation.utils

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    protected fun Disposable.pool() = apply { compositeDisposable.add(this) }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}