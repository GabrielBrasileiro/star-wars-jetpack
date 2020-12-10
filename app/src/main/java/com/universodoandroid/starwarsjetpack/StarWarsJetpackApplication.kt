package com.universodoandroid.starwarsjetpack

import android.app.Application
import com.universodoandroid.starwarsjetpack.koin.KoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("Unused")
class StarWarsJetpackApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@StarWarsJetpackApplication)
            modules(KoinModules().getModules())
        }
    }
}
