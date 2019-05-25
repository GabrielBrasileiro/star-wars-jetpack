package com.universodoandroid.remote.remote.people

import com.universodoandroid.domain.people.PeopleResponse

interface PeopleRemoteDataSource {
    fun loadPeople(page: Int, onSuccess: (PeopleResponse) -> Unit, onError: (Throwable) -> Unit)
}