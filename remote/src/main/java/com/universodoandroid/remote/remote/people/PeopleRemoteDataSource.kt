package com.universodoandroid.remote.remote.people

import com.universodoandroid.domain.people.PeopleResponse

interface PeopleRemoteDataSource {
    fun loadPeople(onSuccess: (result: PeopleResponse) -> Unit, onError: (error: String) -> Unit)
}