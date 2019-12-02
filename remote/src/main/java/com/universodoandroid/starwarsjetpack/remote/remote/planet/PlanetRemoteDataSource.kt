package com.universodoandroid.starwarsjetpack.remote.remote.planet

import com.universodoandroid.starwarsjetpack.remote.remote.planet.response.PlanetResponse

interface PlanetRemoteDataSource {
    fun loadPlanets(page: Int, onSuccess: (result: PlanetResponse) -> Unit, onError: (Throwable) -> Unit)
    fun dispose()
}