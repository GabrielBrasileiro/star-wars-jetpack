package com.universodoandroid.remote.observers

import com.universodoandroid.domain.people.PeopleResponse
import com.universodoandroid.remote.api.PeopleApiDataSource
import com.universodoandroid.remote.data.PeopleReponseDataFactory
import io.reactivex.Observable

class FakePeopleRemoteDataSource : PeopleApiDataSource {

    override fun people(page: Int): Observable<PeopleResponse> {
        return Observable.create { subscriber ->
            val response = PeopleReponseDataFactory.dummyPeopleResponse()
            subscriber.onNext(response)
        }
    }

}