package com.universodoandroid.starwarsjetpack.presentation.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

internal class DefaultRXExecutor : RXExecutor {

    override val executor: Scheduler = Schedulers.io()

    override val observer: Scheduler = AndroidSchedulers.mainThread()

}