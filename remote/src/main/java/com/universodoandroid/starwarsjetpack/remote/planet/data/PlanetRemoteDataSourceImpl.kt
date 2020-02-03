package com.universodoandroid.starwarsjetpack.remote.planet.data

import com.universodoandroid.starwarsjetpack.remote.planet.data.response.PlanetResponse
import com.universodoandroid.starwarsjetpack.remote.planet.api.PlanetApiDataSource
import com.universodoandroid.starwarsjetpack.remote.BaseObserver

class PlanetRemoteDataSourceImpl(val apiDataSource: PlanetApiDataSource) : BaseObserver(),
    PlanetRemoteDataSource {

    companion object {
        private var apiDataSource: PlanetRemoteDataSourceImpl? = null

        fun getInstance(planetApiDataSource: PlanetApiDataSource): PlanetRemoteDataSource {
            if (apiDataSource == null) {
                apiDataSource =
                    PlanetRemoteDataSourceImpl(
                        apiDataSource = planetApiDataSource
                    )
            }

            return apiDataSource!!
        }
    }

    override fun loadPlanets(page: Int, onSuccess: (result: PlanetResponse) -> Unit, onError: (Throwable) -> Unit) {
        buildObserver(apiDataSource.planets(page = page), onSuccess, onError)
    }

    override fun dispose() {
        clear()
    }

}