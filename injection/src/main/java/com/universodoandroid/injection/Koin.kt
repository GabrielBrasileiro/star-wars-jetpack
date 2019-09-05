package com.universodoandroid.injection

import android.content.Context
import com.universodoandroid.injection.local.databaseModule
import com.universodoandroid.injection.local.localModule
import com.universodoandroid.injection.remote.apiModule
import com.universodoandroid.injection.remote.remoteModule
import com.universodoandroid.injection.usecase.policyModule
import com.universodoandroid.injection.usecase.useCaseModule
import com.universodoandroid.injection.viewmodel.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object Koin {

    fun init(context: Context) {
        startKoin {
            androidLogger()
            androidContext(context)
            modules(listOf(
                apiModule,
                remoteModule,
                databaseModule,
                localModule,
                policyModule,
                useCaseModule,
                viewModelModule
            ))
        }
    }

}