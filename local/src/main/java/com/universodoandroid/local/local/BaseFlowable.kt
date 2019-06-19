package com.universodoandroid.local.local

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class BaseFlowable {

    private val disposables = CompositeDisposable()
    private val mainThread  = AndroidSchedulers.mainThread()
    private val ioThread    = Schedulers.io()

    open fun buildCompletable(
        completable: Completable,
        onComplete: (() -> Unit),
        onError: (e: Throwable) -> Unit
    ) {
        val disposable = completable.subscribeOn(ioThread)
            .observeOn(mainThread)
            .subscribe(onComplete, onError)

        addDisposable(disposable)
    }

    open fun <T> buildFlowable(
        flowable: Flowable<T>,
        onNext: (T) -> Unit,
        onError: (e: Throwable) -> Unit,
        onComplete: (() -> Unit)? = null
    ) {
        val disposable = flowable.subscribeOn(ioThread)
            .observeOn(mainThread)
            .subscribe(onNext, onError, {
                onComplete?.invoke()
            })

        addDisposable(disposable)
    }

    fun clear() {
        disposables.clear()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

}