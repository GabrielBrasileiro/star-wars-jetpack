package com.universodoandroid.starwarsjetpack.remote.remote.people

import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PeopleResponse
import io.reactivex.Flowable


internal interface PeopleRemoteDataSource {
    fun loadPeoplePerPage(page: Int): Flowable<PeopleResponse>
}