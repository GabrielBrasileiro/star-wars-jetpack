package com.universodoandroid.presentation.models

import androidx.lifecycle.*
import com.universodoandroid.presentation.dtos.PersonDto
import com.universodoandroid.presentation.mapper.PeopleMapper
import com.universodoandroid.remote.remote.InjectionRemoteDataSource
import com.universodoandroid.remote.usecase.people.GetPeople

class PeopleListViewModel : ViewModel(), LifecycleObserver {

    val peopleLiveData: MutableLiveData<List<PersonDto>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadPeople() {
        GetPeople(InjectionRemoteDataSource.providePeopleRemoteDataSource()).getPeople({ peopleResponse ->
            val peopleDto = PeopleMapper.entityToDto(entities = peopleResponse.results)
            println("PeopleDto: $peopleDto")
            peopleLiveData.postValue(peopleDto)
        }) { error ->
            println("Error: $error")
        }
    }

}