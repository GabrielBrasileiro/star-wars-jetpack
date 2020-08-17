package com.universodoandroid.starwarsjetpack.presentation

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class RxSchedulerRule : TestRule {

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                RxAndroidPlugins.reset()
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { TRAMPOLINE }

                RxJavaPlugins.reset()
                RxJavaPlugins.setIoSchedulerHandler { TRAMPOLINE }
                RxJavaPlugins.setComputationSchedulerHandler { TRAMPOLINE }
                RxJavaPlugins.setNewThreadSchedulerHandler { TRAMPOLINE }

                base.evaluate()
            }
        }
    }

    private companion object {
        val TRAMPOLINE = Schedulers.trampoline()
    }
}