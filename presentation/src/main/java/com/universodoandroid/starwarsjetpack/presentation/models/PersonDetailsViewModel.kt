package com.universodoandroid.starwarsjetpack.presentation.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.domain.usecase.people.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.dto.PersonDetailsDto
import com.universodoandroid.starwarsjetpack.presentation.mapper.PeopleMapper
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel
import com.universodoandroid.starwarsjetpack.presentation.utils.ViewState

class PersonDetailsViewModel(
    private val useCase: GetPersonUseCase
) : BaseViewModel() {

    private val state: MutableLiveData<ViewState<PersonDetailsDto, String>> = MutableLiveData()

    fun getState(): LiveData<ViewState<PersonDetailsDto, String>> = state

    fun loadPerson(id: String) {
        if (id != state.value?.data?.id) {
            isLoadingObserver.postValue(true)
            useCase.loadPerson(id, {
                val personDto = PeopleMapper.entityToDto(it)
                state.postValue(ViewState(ViewState.Status.SUCCESS, personDto))
                isLoadingObserver.postValue(false)
            }) {
                state.postValue(ViewState(ViewState.Status.ERROR, error = it.localizedMessage))
                isLoadingObserver.postValue(false)
            }
        }
    }

}