package com.universodoandroid.presentation.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.universodoandroid.presentation.ViewState
import com.universodoandroid.presentation.dto.PersonDetailsDto
import com.universodoandroid.presentation.mapper.PeopleMapper
import com.universodoandroid.remote.usecase.people.PeopleUseCase

class PersonDetailsViewModel(private val useCase: PeopleUseCase) : ViewModel() {

    val state: MutableLiveData<ViewState<PersonDetailsDto, String>> = MutableLiveData()

    fun loadPerson(id: String) {
        if (id != state.value?.data?.id) {
            state.postValue(ViewState(ViewState.Status.LOADING))
            useCase.loadPerson(id, {
                val personDto = PeopleMapper.entityToDto(it)
                state.postValue(ViewState(ViewState.Status.SUCCESS, personDto))
            }) {
                state.postValue(ViewState(ViewState.Status.ERROR, error = it.localizedMessage))
            }
        }
    }

}