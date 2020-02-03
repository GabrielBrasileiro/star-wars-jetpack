package com.universodoandroid.starwarsjetpack.remote.people.data

import com.universodoandroid.starwarsjetpack.remote.people.api.PeopleApiDataSource

internal class PeopleRemoteDataSourceImpl(
    private val apiDataSource: PeopleApiDataSource
) : PeopleRemoteDataSource {

    override fun loadPeoplePerPage(page: Int) = apiDataSource.loadPeople(page)

}