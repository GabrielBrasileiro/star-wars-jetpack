package com.universodoandroid.remote.remote.planet

import com.universodoandroid.domain.planet.PlanetResponse

interface PlanetRemoteDataSource {
    fun loadPlanets(page: Int, onSuccess: (result: PlanetResponse) -> Unit, onError: (Throwable) -> Unit)
}