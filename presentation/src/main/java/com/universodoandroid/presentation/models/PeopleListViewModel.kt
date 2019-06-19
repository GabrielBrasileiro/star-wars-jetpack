package com.universodoandroid.presentation.models

import android.app.Application
import androidx.lifecycle.*
import com.universodoandroid.presentation.BaseViewModel
import com.universodoandroid.presentation.ViewState
import com.universodoandroid.presentation.dto.PersonDto
import com.universodoandroid.presentation.mapper.PeopleMapper
import com.universodoandroid.remote.remote.BaseObserver
import com.universodoandroid.remote.usecase.InjectionUseCase
import com.universodoandroid.remote.usecase.people.PeopleUseCase

class PeopleListViewModel(private val application: Application) : BaseViewModel(), LifecycleObserver {

    private val useCase: PeopleUseCase by lazy {
        InjectionUseCase.providePeopleUseCase(application)
    }

    val state: MutableLiveData<ViewState<List<PersonDto>, String>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadPeople() {
        isLoadingObserver.postValue(true)
        useCase.getPeople({ people ->
            val peopleDto = PeopleMapper.entityToDto(entities = people)
            state.postValue(ViewState(ViewState.Status.SUCCESS, data = peopleDto))
            isLoadingObserver.postValue(false)
        }) { error ->
            state.postValue(ViewState(ViewState.Status.ERROR, error = error.localizedMessage))
            isLoadingObserver.postValue(false)
        }
    }

    override fun onCleared() {
        super.onCleared()
        useCase.dispose()
    }

}