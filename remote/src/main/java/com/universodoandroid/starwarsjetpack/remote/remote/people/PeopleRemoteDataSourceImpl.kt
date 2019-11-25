package com.universodoandroid.starwarsjetpack.remote.remote.people

import com.universodoandroid.starwarsjetpack.remote.api.PeopleApiDataSource
import com.universodoandroid.starwarsjetpack.remote.remote.BaseObserver
import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PeopleResponse

class PeopleRemoteDataSourceImpl(private val apiDataSource: PeopleApiDataSource) : BaseObserver(),
    PeopleRemoteDataSource {

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

    override fun dispose() {
        clear()
    }

}