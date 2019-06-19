package com.universodoandroid.remote.remote

import com.universodoandroid.remote.api.InjectionApiDataSourceMain
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSource
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSourceImpl
import com.universodoandroid.remote.remote.planet.PlanetRemoteDataSource
import com.universodoandroid.remote.remote.planet.PlanetRemoteDataSourceImpl

object InjectionRemoteDataSource {

    fun providePeopleRemoteDataSource(): PeopleRemoteDataSource {
        val peopleApiDataSourceMain = InjectionApiDataSourceMain.providePeopleApiDataSource()
        return PeopleRemoteDataSourceImpl.getInstance(peopleApiDataSource = peopleApiDataSourceMain)
    }

    fun providePlanetRemoteDataSource(): PlanetRemoteDataSource {
        val planetApiDataSource = InjectionApiDataSourceMain.providePlanetApiDataSource()
        return PlanetRemoteDataSourceImpl.getInstance(planetApiDataSource)
    }

}