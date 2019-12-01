package com.universodoandroid.starwarsjetpack.remote.api

import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PeopleResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PeopleApiDataSource {

    @GET("people")
    fun loadPeople(@Query("page") page: Int): Flowable<PeopleResponse>

}