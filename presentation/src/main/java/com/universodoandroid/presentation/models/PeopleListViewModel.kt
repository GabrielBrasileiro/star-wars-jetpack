package com.universodoandroid.presentation.models

import androidx.lifecycle.*
import com.universodoandroid.presentation.dtos.PersonDto
import com.universodoandroid.presentation.mapper.PeopleMapper
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSource
import com.universodoandroid.remote.usecase.people.GetPeople

class PeopleListViewModel(private val peopleRemoteDataSource: PeopleRemoteDataSource) : ViewModel(), LifecycleObserver {

    private val peopleLiveData: MutableLiveData<List<PersonDto>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadPeople() {
        GetPeople(peopleRemoteDataSource).getPeople({ peopleResponse ->
            val peopleDto = PeopleMapper.entityToDto(entities = peopleResponse.results)
            peopleLiveData.postValue(peopleDto)
        }) { error ->
            println("Error: $error")
        }
    }

}