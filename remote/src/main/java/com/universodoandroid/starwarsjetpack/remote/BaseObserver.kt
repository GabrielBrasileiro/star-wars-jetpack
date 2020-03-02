package com.universodoandroid.starwarsjetpack.remote

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

open class BaseObserver {

    private val disposables = CompositeDisposable()
    private val mainThread = AndroidSchedulers.mainThread()
    private val ioThread = Schedulers.io()

    open fun <T> buildObserver(
        observer: Observable<T>,
        onNext: (T) -> Unit,
        onError: (e: Throwable) -> Unit,
        onComplete: (() -> Unit)? = null
    ) {
        val disposable = observer.subscribeOn(ioThread)
            .observeOn(mainThread)
            .subscribe(onNext, onError, {
                onComplete?.invoke()
            })

        disposables.add(disposable)
    }

    fun clear() {
        disposables.clear()
    }

}