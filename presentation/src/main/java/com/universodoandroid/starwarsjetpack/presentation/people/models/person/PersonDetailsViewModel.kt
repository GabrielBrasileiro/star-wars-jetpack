package com.universodoandroid.starwarsjetpack.presentation.people.models.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDetailsDto
import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PeopleMapper
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel
import com.universodoandroid.starwarsjetpack.presentation.utils.ViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PersonDetailsViewModel(
    private val getPersonUseCase: GetPersonUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val state: MutableLiveData<ViewState<PersonDetailsDto, String>> = MutableLiveData()

    fun getState(): LiveData<ViewState<PersonDetailsDto, String>> = state

    fun loadPerson(id: String) {
        val disposable = getPersonUseCase.loadPerson(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val personDto = PeopleMapper.entityToDto(it)
                state.postValue(ViewState(ViewState.Status.SUCCESS, personDto))
            }, {
                state.postValue(ViewState(ViewState.Status.ERROR, error = it.localizedMessage))
            })

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}