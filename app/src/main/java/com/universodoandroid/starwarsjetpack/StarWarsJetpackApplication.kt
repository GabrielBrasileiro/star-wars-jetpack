package com.universodoandroid.starwarsjetpack

import android.app.Application
import com.universodoandroid.starwarsjetpack.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("Unused")
class StarWarsJetpackApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@StarWarsJetpackApplication)
            modules(listOf(
                viewModelModule
            ))
        }
    }

}