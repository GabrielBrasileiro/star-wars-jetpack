package com.universodoandroid.starwarsjetpack.presentation.people.models.people

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PeopleMapper
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PeopleListViewModel(
    private val getPeopleUseCase: GetPeopleUseCase
) : BaseViewModel<PeopleState>(), LifecycleObserver {

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