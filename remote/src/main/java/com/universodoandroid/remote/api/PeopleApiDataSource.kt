package com.universodoandroid.remote.api

import com.universodoandroid.domain.people.PeopleResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface PeopleApiDataSource {

    @GET("people")
    fun people(): Observable<PeopleResponse>

}