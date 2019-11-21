package com.universodoandroid.remote.remote.people

import com.universodoandroid.domain.entities.people.PeopleResponse

interface PeopleRemoteDataSource {
    fun loadPeople(page: Int, onSuccess: (PeopleResponse) -> Unit, onError: (Throwable) -> Unit)
    fun dispose()
}