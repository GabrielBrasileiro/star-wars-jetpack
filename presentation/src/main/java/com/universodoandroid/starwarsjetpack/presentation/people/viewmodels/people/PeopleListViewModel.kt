package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people

import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.core.reducer.Reducer
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer.PeopleEvent
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer.PeopleStateEvent
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.reducer.PeopleState
import com.universodoandroid.starwarsjetpack.presentation.rx.RXExecutor
import com.universodoandroid.starwarsjetpack.presentation.utils.RXBaseViewModel
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PeopleListViewModel(
    event: SingleLiveEvent<PeopleEvent>,
    reducer: Reducer<PeopleState, PeopleStateEvent>,
    private val getPeopleUseCase: GetPeopleUseCase,
    private val mapper: Mapper<Person, PersonPresentation>,
    private val rx: RXExecutor
) : RXBaseViewModel<PeopleState, PeopleEvent, PeopleStateEvent>(event, reducer) {

    init {
        loadPeople()
    }

    private fun loadPeople() {
        getPeopleUseCase.getPeople()
            .subscribeOn(rx.executor)
            .observeOn(rx.observer)
            .doOnSubscribe { sendEvent(PeopleEvent.ShowLoading) }
            .doFinally { sendEvent(PeopleEvent.HideLoading) }
            .map { it.map(mapper::map) }
            .subscribe({
                updateTo(PeopleStateEvent.ShowPeopleData(it))
            }, {
                sendEvent(PeopleEvent.ShowError(it.localizedMessage))
            })
            .pool()
    }
}