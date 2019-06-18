package com.universodoandroid.remote.remote.people

import com.universodoandroid.domain.people.PeopleResponse
import com.universodoandroid.remote.api.PeopleApiDataSource
import com.universodoandroid.remote.remote.BaseObserver

class PeopleRemoteDataSourceImpl(val apiDataSource: PeopleApiDataSource) : BaseObserver(), PeopleRemoteDataSource {

    companion object {
        private var apiDataSource: PeopleRemoteDataSourceImpl? = null

        fun getInstance(peopleApiDataSource: PeopleApiDataSource): PeopleRemoteDataSource {
            if (apiDataSource == null) {
                apiDataSource = PeopleRemoteDataSourceImpl(apiDataSource = peopleApiDataSource)
            }

            return apiDataSource!!
        }
    }

    override fun loadPeople(page: Int, onSuccess: (result: PeopleResponse) -> Unit, onError: (Throwable) -> Unit) {
        buildObserver(apiDataSource.people(page = page), onSuccess, onError)
    }

}