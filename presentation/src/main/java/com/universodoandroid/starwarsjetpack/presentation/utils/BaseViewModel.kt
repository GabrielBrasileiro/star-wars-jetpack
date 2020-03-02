package com.universodoandroid.starwarsjetpack.presentation.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel<State : ViewState> : ViewModel() {

    private val state: MutableLiveData<State> = MutableLiveData()

    fun getState(): LiveData<State> = state

    private val compositeDisposable by lazy { CompositeDisposable() }

    protected fun setState(_state: State) { state.value = _state }

    protected fun Disposable.pool() = apply { compositeDisposable.add(this) }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}