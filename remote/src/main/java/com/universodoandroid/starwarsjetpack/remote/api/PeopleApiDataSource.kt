package com.universodoandroid.starwarsjetpack.remote.api

import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PeopleResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleApiDataSource {

    @GET("people")
    fun people(@Query("page") page: Int): Observable<PeopleResponse>

}