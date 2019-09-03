package com.universodoandroid.presentation.models

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.presentation.BaseViewModel
import com.universodoandroid.presentation.ViewState
import com.universodoandroid.presentation.dto.PersonDetailsDto
import com.universodoandroid.presentation.mapper.PeopleMapper
import com.universodoandroid.remote.usecase.InjectionUseCase
import com.universodoandroid.remote.usecase.people.PeopleUseCase
import com.universodoandroid.remote.usecase.people.PeopleUseCaseImpl

class PersonDetailsViewModel(application: Application) : BaseViewModel() {

    private val useCase: PeopleUseCase by lazy { InjectionUseCase.providePeopleUseCase(application) }

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