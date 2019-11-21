package com.universodoandroid.presentation.models

import androidx.lifecycle.*
import com.universodoandroid.presentation.dto.PersonDto
import com.universodoandroid.presentation.mapper.PeopleMapper
import com.universodoandroid.presentation.utils.BaseViewModel
import com.universodoandroid.presentation.utils.ViewState
import com.universodoandroid.domain.usecase.people.PeopleUseCase

class PeopleListViewModel(private val useCase: PeopleUseCase) : BaseViewModel(), LifecycleObserver {

    private val state: MutableLiveData<ViewState<List<PersonDto>, String>> = MutableLiveData()

    fun getState(): LiveData<ViewState<List<PersonDto>, String>> = state

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