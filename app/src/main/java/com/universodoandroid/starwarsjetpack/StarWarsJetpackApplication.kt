package com.universodoandroid.starwarsjetpack

import android.app.Application
import com.universodoandroid.injection.Koin

@Suppress("Unused")
class StarWarsJetpackApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Koin.init(this)
    }

}