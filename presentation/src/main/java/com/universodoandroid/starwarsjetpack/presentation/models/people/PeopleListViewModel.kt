package com.universodoandroid.starwarsjetpack.presentation.models.people

import androidx.lifecycle.*
import com.universodoandroid.starwarsjetpack.domain.usecase.people.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.mapper.PeopleMapper
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PeopleListViewModel(
    private val getPeopleUseCase: GetPeopleUseCase
) : BaseViewModel(), LifecycleObserver {

    private val state: MutableLiveData<PeopleState> = MutableLiveData()

    fun getState(): LiveData<PeopleState> = state

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadPeople() {
        state.value = PeopleState.ShowLoading

        getPeopleUseCase.getPeople()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val peopleDto = PeopleMapper.entityToDto(entities = it)

                state.value = PeopleState.HideLoading
                state.postValue(PeopleState.ShowData(peopleDto))
            }, {
                state.value = PeopleState.HideLoading
                state.postValue(PeopleState.ShowError(it.localizedMessage))
            })
            .pool()
    }

}