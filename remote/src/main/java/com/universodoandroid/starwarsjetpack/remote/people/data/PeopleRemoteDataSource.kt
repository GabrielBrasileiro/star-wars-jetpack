package com.universodoandroid.starwarsjetpack.remote.people.data

import com.universodoandroid.starwarsjetpack.remote.people.data.response.PeopleResponse
import io.reactivex.Flowable


internal interface PeopleRemoteDataSource {
    fun loadPeoplePerPage(page: Int): Flowable<PeopleResponse>
}