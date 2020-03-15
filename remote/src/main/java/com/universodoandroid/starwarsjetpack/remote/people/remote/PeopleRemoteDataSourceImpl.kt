package com.universodoandroid.starwarsjetpack.remote.people.remote

import com.universodoandroid.starwarsjetpack.remote.people.api.PeopleApi
import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PeopleResponse
import io.reactivex.Flowable

internal class PeopleRemoteDataSourceImpl(
    private val api: PeopleApi
) : PeopleRemoteDataSource {

    override fun loadPeoplePerPage(page: Int): Flowable<PeopleResponse> {
        return api.loadPeople(page)
    }

}