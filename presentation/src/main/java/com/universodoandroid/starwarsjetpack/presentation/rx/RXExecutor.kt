package com.universodoandroid.starwarsjetpack.presentation.rx

import io.reactivex.Scheduler

interface RXExecutor {
    val executor: Scheduler
    val observer: Scheduler
}