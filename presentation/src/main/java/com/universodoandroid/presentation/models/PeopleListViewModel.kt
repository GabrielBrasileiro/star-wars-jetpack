package com.universodoandroid.presentation.models

import android.app.Application
import androidx.lifecycle.*
import com.universodoandroid.presentation.ViewState
import com.universodoandroid.presentation.dto.PersonDto
import com.universodoandroid.presentation.mapper.PeopleMapper
import com.universodoandroid.remote.remote.InjectionRemoteDataSource
import com.universodoandroid.remote.usecase.people.GetPeople

class PeopleListViewModel(private val application: Application) : ViewModel(), LifecycleObserver {

    val state: MutableLiveData<ViewState<List<PersonDto>, String>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadPeople() {
        state.postValue(ViewState(ViewState.Status.LOADING))
        GetPeople(application, InjectionRemoteDataSource.providePeopleRemoteDataSource()).getPeople({ peopleResponse ->
            val peopleDto = PeopleMapper.entityToDto(entities = peopleResponse.results)
            state.postValue(ViewState(ViewState.Status.SUCCESS, data = peopleDto))
        }) { error ->
            state.postValue(ViewState(ViewState.Status.ERROR, error = error))
        }
    }

}