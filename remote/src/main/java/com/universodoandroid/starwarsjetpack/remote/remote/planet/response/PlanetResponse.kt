package com.universodoandroid.starwarsjetpack.remote.remote.planet.response

import com.universodoandroid.starwarsjetpack.remote.remote.planet.response.Planet

data class PlanetResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val planets: List<Planet>
)