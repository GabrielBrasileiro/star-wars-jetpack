package com.universodoandroid.starwarsjetpack.domain.common.executors

import io.reactivex.Scheduler

interface PostExecutorThread {
    val scheduler: Scheduler
}