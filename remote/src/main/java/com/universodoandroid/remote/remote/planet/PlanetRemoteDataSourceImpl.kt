package com.universodoandroid.remote.remote.planet

import com.universodoandroid.domain.planet.PlanetResponse
import com.universodoandroid.remote.api.PlanetApiDataSource
import com.universodoandroid.remote.remote.BaseObserver

class PlanetRemoteDataSourceImpl(val apiDataSource: PlanetApiDataSource) : BaseObserver(), PlanetRemoteDataSource {

    companion object {
        private var apiDataSource: PlanetRemoteDataSourceImpl? = null

        fun getInstance(planetApiDataSource: PlanetApiDataSource): PlanetRemoteDataSource {
            if (apiDataSource == null) {
                apiDataSource = PlanetRemoteDataSourceImpl(apiDataSource = planetApiDataSource)
            }

            return apiDataSource!!
        }
    }

    override fun loadPlanets(page: Int, onSuccess: (result: PlanetResponse) -> Unit, onError: (Throwable) -> Unit) {
        buildObserver(apiDataSource.planets(page = page), onSuccess, onError)
    }

}