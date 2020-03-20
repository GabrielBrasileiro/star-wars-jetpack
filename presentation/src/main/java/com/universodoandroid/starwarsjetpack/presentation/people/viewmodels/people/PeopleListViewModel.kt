package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.BaseViewModel
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PeopleListViewModel(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val mapper: Mapper<Person, PersonPresentation>
) : BaseViewModel<PeopleEvent, PeopleState>() {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadPeople() {
        getPeopleUseCase.getPeople()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { setEvent(PeopleEvent.ShowLoading) }
            .doFinally { setEvent(PeopleEvent.HideLoading) }
            .subscribe({
                val peopleDto = it.map { person -> mapper.map(person) }
                setState(PeopleState(peopleDto))
            }, {
                setEvent(PeopleEvent.ShowError(it.localizedMessage))
            })
            .pool()
    }

}