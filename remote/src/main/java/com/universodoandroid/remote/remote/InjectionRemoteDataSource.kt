package com.universodoandroid.remote.remote

import com.universodoandroid.remote.api.InjectionApiDataSourceMain
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSource
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSourceImpl

object InjectionRemoteDataSource {

    fun providePeopleRemoteDataSource(): PeopleRemoteDataSource {
        val peopleApiDataSourceMain = InjectionApiDataSourceMain.providePeopleApiDataSource()
        return PeopleRemoteDataSourceImpl.getInstance(peopleApiDataSource = peopleApiDataSourceMain)
    }

}