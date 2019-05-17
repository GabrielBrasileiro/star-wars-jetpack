package com.universodoandroid.remote.usecase.people

import com.universodoandroid.domain.people.PeopleResponse
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSource

class GetPeople(private val peopleRemoteDataSource: PeopleRemoteDataSource) {

    fun getPeople(onSuccess: (PeopleResponse) -> Unit, onError: (error: String) -> Unit) {
        peopleRemoteDataSource.loadPeople(onSuccess, onError)
    }

}