package com.universodoandroid.starwarsjetpack.presentation

import com.universodoandroid.starwarsjetpack.presentation.rx.RXExecutor
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

internal class DefaultRXTestExecutor : RXExecutor {
    override val executor: Scheduler = Schedulers.trampoline()
    override val observer: Scheduler = Schedulers.trampoline()
}