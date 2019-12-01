package com.universodoandroid.starwarsjetpack.domain.common.executors

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCaseExecutor(
    private val postExecutorThread: PostExecutorThread
) {

    private val disposables = CompositeDisposable()
    private val ioThread = Schedulers.io()

    open fun execute(
        completable: Completable,
        onComplete: (() -> Unit),
        onError: (e: Throwable) -> Unit
    ) {
        val disposable = completable
            .subscribeOn(ioThread)
            .observeOn(postExecutorThread.scheduler)
            .subscribe(onComplete, onError)

        addDisposable(disposable)
    }

    open fun <T> execute(
        flowable: Flowable<T>,
        onNext: (T) -> Unit,
        onError: (e: Throwable) -> Unit,
        onComplete: (() -> Unit)? = null
    ) {
        val disposable = flowable.subscribeOn(ioThread)
            .observeOn(postExecutorThread.scheduler)
            .subscribe(onNext, onError, {
                onComplete?.invoke()
            })

        addDisposable(disposable)
    }

    fun dispose() = disposables.clear()

    private fun addDisposable(disposable: Disposable) = disposables.add(disposable)

}