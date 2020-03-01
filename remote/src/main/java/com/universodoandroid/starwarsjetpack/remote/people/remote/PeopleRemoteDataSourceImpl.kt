package com.universodoandroid.starwarsjetpack.remote.people.remote

import com.universodoandroid.starwarsjetpack.remote.people.api.PeopleApi

internal class PeopleRemoteDataSourceImpl(
    private val api: PeopleApi
) : PeopleRemoteDataSource {

    override fun loadPeoplePerPage(page: Int) = api.loadPeople(page)

}