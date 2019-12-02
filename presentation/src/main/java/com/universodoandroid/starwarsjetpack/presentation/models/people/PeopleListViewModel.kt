package com.universodoandroid.starwarsjetpack.presentation.models.people

import androidx.lifecycle.*
import com.universodoandroid.starwarsjetpack.domain.usecase.people.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.mapper.PeopleMapper
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel

class PeopleListViewModel(
    private val getPeopleUseCase: GetPeopleUseCase
) : BaseViewModel(), LifecycleObserver {

    private val state: MutableLiveData<PeopleState> = MutableLiveData()

    fun getState(): LiveData<PeopleState> = state

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadPeople() {
        state.value = PeopleState.ShowLoading

        getPeopleUseCase.getPeople({ people ->
            val peopleDto = PeopleMapper.entityToDto(entities = people)
            state.postValue(PeopleState.ShowData(peopleDto))
            state.value = PeopleState.HideLoading
        }) { error ->
            state.postValue(PeopleState.ShowError(error.localizedMessage))
            state.value = PeopleState.HideLoading
        }
    }

    override fun onCleared() {
        super.onCleared()
        getPeopleUseCase.dispose()
    }

}