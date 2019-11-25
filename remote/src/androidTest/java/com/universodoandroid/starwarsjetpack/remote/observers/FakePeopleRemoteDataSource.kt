package com.universodoandroid.starwarsjetpack.remote.observers

import com.universodoandroid.starwarsjetpack.remote.api.PeopleApiDataSource
import com.universodoandroid.starwarsjetpack.remote.data.PeopleReponseDataFactory
import com.universodoandroid.starwarsjetpack.remote.remote.people.response.PeopleResponse
import io.reactivex.Observable

class FakePeopleRemoteDataSource : PeopleApiDataSource {

    override fun people(page: Int): Observable<PeopleResponse> {
        return Observable.create { subscriber ->
            val response = PeopleReponseDataFactory.dummyPeopleResponse()
            subscriber.onNext(response)
        }
    }

}