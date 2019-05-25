package com.universodoandroid.remote.api

import com.universodoandroid.domain.people.PeopleResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleApiDataSource {

    @GET("people")
    fun people(@Query("page") page: Int): Observable<PeopleResponse>

}