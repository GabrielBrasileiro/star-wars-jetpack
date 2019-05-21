package com.universodoandroid.remote.remote.people

import com.universodoandroid.domain.people.PeopleResponse

interface PeopleRemoteDataSource {
    fun loadPeople(onSuccess: (PeopleResponse) -> Unit, onError: (Throwable) -> Unit)
}