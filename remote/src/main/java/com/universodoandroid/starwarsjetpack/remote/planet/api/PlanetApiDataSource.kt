package com.universodoandroid.starwarsjetpack.remote.planet.api

import com.universodoandroid.starwarsjetpack.remote.planet.data.response.PlanetResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PlanetApiDataSource {

    @GET("planets")
    fun planets(@Query("page") page: Int): Observable<PlanetResponse>

}