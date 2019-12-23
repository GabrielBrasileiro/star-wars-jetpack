package com.universodoandroid.starwarsjetpack.presentation.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.domain.usecase.people.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.dto.PersonDetailsDto
import com.universodoandroid.starwarsjetpack.presentation.mapper.PeopleMapper
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel
import com.universodoandroid.starwarsjetpack.presentation.utils.ViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PersonDetailsViewModel(
    private val getPersonUseCase: GetPersonUseCase
) : BaseViewModel() {

    private val state: MutableLiveData<ViewState<PersonDetailsDto, String>> = MutableLiveData()

    fun getState(): LiveData<ViewState<PersonDetailsDto, String>> = state

    fun loadPerson(id: String) {
        getPersonUseCase.loadPerson(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val personDto = PeopleMapper.entityToDto(it)
                state.postValue(ViewState(ViewState.Status.SUCCESS, personDto))
            }, {
                state.postValue(ViewState(ViewState.Status.ERROR, error = it.localizedMessage))
            })
            .pool()
    }

}