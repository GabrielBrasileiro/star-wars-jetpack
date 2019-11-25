package com.universodoandroid.starwarsjetpack.presentation.models

import androidx.lifecycle.*
import com.universodoandroid.starwarsjetpack.presentation.dto.PersonDto
import com.universodoandroid.starwarsjetpack.presentation.mapper.PeopleMapper
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel
import com.universodoandroid.starwarsjetpack.presentation.utils.ViewState
import com.universodoandroid.starwarsjetpack.domain.usecase.people.PeopleUseCase

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