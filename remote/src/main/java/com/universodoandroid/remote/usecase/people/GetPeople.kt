package com.universodoandroid.remote.usecase.people

import android.annotation.SuppressLint
import android.app.Application
import com.universodoandroid.domain.people.PeopleResponse
import com.universodoandroid.local.AppDatabase
import com.universodoandroid.local.PersonRoomRepository
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class GetPeople(private val application: Application, private val peopleRemoteDataSource: PeopleRemoteDataSource) {

    private val repository: PersonRoomRepository by lazy {
        PersonRoomRepository(AppDatabase.getDatabase(application))
    }

    fun getPeople(onSuccess: (PeopleResponse) -> Unit, onError: (error: String) -> Unit) {
        repository.loadPeople()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (it.isEmpty()) {
                    peopleRemoteDataSource.loadPeople(onSuccess, onError)
                } else {

                }
            }
    }

    fun getPerson(uuid: String) {

    }

}