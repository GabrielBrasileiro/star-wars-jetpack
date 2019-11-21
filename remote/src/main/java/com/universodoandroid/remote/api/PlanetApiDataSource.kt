package com.universodoandroid.remote.api

import com.universodoandroid.domain.entities.planet.PlanetResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PlanetApiDataSource {

    @GET("planets")
    fun planets(@Query("page") page: Int): Observable<PlanetResponse>

}