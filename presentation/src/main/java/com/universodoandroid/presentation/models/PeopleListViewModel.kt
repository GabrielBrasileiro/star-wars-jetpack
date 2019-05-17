package com.universodoandroid.presentation.models

import android.app.Application
import androidx.lifecycle.*
import com.universodoandroid.presentation.dtos.PersonDto
import com.universodoandroid.presentation.mapper.PeopleMapper
import com.universodoandroid.remote.remote.InjectionRemoteDataSource
import com.universodoandroid.remote.usecase.people.GetPeople

class PeopleListViewModel(private val application: Application) : ViewModel(), LifecycleObserver {

    val peopleLiveData: MutableLiveData<List<PersonDto>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadPeople() {
        GetPeople(application, InjectionRemoteDataSource.providePeopleRemoteDataSource()).getPeople({ peopleResponse ->
            val peopleDto = PeopleMapper.entityToDto(entities = peopleResponse.results)
            peopleLiveData.postValue(peopleDto)
        }) { error ->
            println("Error: $error")
        }
    }

}