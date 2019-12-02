package com.universodoandroid.starwarsjetpack.remote.api

import com.universodoandroid.starwarsjetpack.remote.remote.planet.response.PlanetResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PlanetApiDataSource {

    @GET("planets")
    fun planets(@Query("page") page: Int): Observable<PlanetResponse>

}