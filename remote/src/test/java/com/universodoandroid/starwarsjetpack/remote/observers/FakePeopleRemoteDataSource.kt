package com.universodoandroid.starwarsjetpack.remote.observers

import com.universodoandroid.starwarsjetpack.remote.people.api.PeopleApiDataSource
import com.universodoandroid.starwarsjetpack.remote.data.PeopleReponseDataFactory
import com.universodoandroid.starwarsjetpack.remote.people.data.response.PeopleResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable

class FakePeopleRemoteDataSource :
    PeopleApiDataSource {

    override fun loadPeople(page: Int): Flowable<PeopleResponse> {
        return Observable.create<PeopleResponse> {
            val response = PeopleReponseDataFactory.dummyPeopleResponse()
            it.onNext(response)
        }.toFlowable(BackpressureStrategy.LATEST)
    }

}