package com.universodoandroid.starwarsjetpack.remote.people.remote

import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PeopleResponse
import io.reactivex.Flowable


internal interface PeopleRemoteDataSource {
    fun loadPeoplePerPage(page: Int): Flowable<PeopleResponse>
}