package com.universodoandroid.starwarsjetpack.remote.people.api

import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PeopleResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PeopleApi {

    @GET("people")
    fun loadPeople(@Query("page") page: Int): Flowable<PeopleResponse>

}