package com.universodoandroid.starwarsjetpack.remote.planet.data.response

data class PlanetResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val planets: List<Planet>
)