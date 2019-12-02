package com.universodoandroid.starwarsjetpack.domain.executors

import io.reactivex.Scheduler

interface PostExecutorThread {
    val scheduler: Scheduler
}