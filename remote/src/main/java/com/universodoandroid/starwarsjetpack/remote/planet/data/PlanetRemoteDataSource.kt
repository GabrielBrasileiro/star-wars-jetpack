package com.universodoandroid.starwarsjetpack.remote.planet.data

import com.universodoandroid.starwarsjetpack.remote.planet.data.response.PlanetResponse

interface PlanetRemoteDataSource {
    fun loadPlanets(page: Int, onSuccess: (result: PlanetResponse) -> Unit, onError: (Throwable) -> Unit)
    fun dispose()
}