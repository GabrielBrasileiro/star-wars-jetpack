package com.universodoandroid.injection

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object Koin {

    fun init(context: Context) {
        startKoin {
            androidLogger()
            androidContext(context)
            modules(listOf(
                useCaseModule,
                viewModelModule
            ))
        }
    }

}