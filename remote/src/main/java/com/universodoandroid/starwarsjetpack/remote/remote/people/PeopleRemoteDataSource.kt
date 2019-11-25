package com.universodoandroid.starwarsjetpack.remote.remote.people

import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PeopleResponse


interface PeopleRemoteDataSource {
    fun loadPeople(page: Int, onSuccess: (PeopleResponse) -> Unit, onError: (Throwable) -> Unit)
    fun dispose()
}