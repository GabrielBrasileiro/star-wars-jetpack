package com.universodoandroid.domain.entities.planet

data class PlanetResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val planets: List<Planet>
)