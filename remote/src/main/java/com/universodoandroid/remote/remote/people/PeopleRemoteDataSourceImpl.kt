package com.universodoandroid.remote.remote.people

import android.annotation.SuppressLint
import com.universodoandroid.domain.people.PeopleResponse
import com.universodoandroid.remote.api.PeopleApiDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class PeopleRemoteDataSourceImpl(val apiDataSource: PeopleApiDataSource) : PeopleRemoteDataSource {

    companion object {
        private var apiDataSource: PeopleRemoteDataSourceImpl? = null

        fun getInstance(peopleApiDataSource: PeopleApiDataSource): PeopleRemoteDataSource {
            if (apiDataSource == null) {
                apiDataSource = PeopleRemoteDataSourceImpl(apiDataSource = peopleApiDataSource)
            }

            return apiDataSource!!
        }
    }

    override fun loadPeople(onSuccess: (result: PeopleResponse) -> Unit, onError: (Throwable) -> Unit) {
        apiDataSource.people()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onError)
    }


}