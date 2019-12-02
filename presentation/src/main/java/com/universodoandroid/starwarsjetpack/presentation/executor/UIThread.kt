package com.universodoandroid.starwarsjetpack.presentation.executor

import com.universodoandroid.starwarsjetpack.domain.executors.PostExecutorThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread : PostExecutorThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}