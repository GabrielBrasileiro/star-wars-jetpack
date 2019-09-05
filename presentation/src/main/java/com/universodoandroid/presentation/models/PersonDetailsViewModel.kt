package com.universodoandroid.presentation.models

import androidx.lifecycle.MutableLiveData
import com.universodoandroid.presentation.dto.PersonDetailsDto
import com.universodoandroid.presentation.mapper.PeopleMapper
import com.universodoandroid.presentation.utils.BaseViewModel
import com.universodoandroid.presentation.utils.ViewState
import com.universodoandroid.remote.usecase.people.PeopleUseCase

class PersonDetailsViewModel(private val useCase: PeopleUseCase) : BaseViewModel() {

    val state: MutableLiveData<ViewState<PersonDetailsDto, String>> = MutableLiveData()

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