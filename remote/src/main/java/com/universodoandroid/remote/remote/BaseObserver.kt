package com.universodoandroid.remote.remote

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class BaseObserver {

    private val mainThread = AndroidSchedulers.mainThread()
    private val ioThread = Schedulers.io()

    @SuppressLint("CheckResult")
    open fun <T> buildObserver(
        observer: Observable<T>,
        onNext: (T) -> Unit,
        onError: (e: Throwable) -> Unit,
        onComplete: (() -> Unit)? = null
    ) {
        observer.subscribeOn(ioThread)
            .observeOn(mainThread)
            .subscribe(onNext, onError, {
                onComplete?.invoke()
            })
    }

}