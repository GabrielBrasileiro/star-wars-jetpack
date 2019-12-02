package com.universodoandroid.starwarsjetpack.remote.remote.people

import com.universodoandroid.starwarsjetpack.remote.api.PeopleApiDataSource

internal class PeopleRemoteDataSourceImpl(
    private val apiDataSource: PeopleApiDataSource
) : PeopleRemoteDataSource {

    override fun loadPeoplePerPage(page: Int) = apiDataSource.loadPeople(page)

}