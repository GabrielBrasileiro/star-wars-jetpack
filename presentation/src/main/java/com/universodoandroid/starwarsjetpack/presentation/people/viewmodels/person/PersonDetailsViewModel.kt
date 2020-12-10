package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person

import com.mvvmredux.core.livedata.SingleLiveEvent
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person.model.PersonDetailsPresentation
import com.universodoandroid.starwarsjetpack.presentation.rx.RXExecutor
import com.universodoandroid.starwarsjetpack.presentation.utils.RXEventViewModel
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PersonDetailsViewModel(
    event: SingleLiveEvent<PersonEvent>,
    private val getPersonUseCase: GetPersonUseCase,
    private val mapper: Mapper<Person, PersonDetailsPresentation>,
    private val rx: RXExecutor
) : RXEventViewModel<PersonEvent>(event) {

    fun loadPerson(id: String) {
        getPersonUseCase.loadPerson(id)
            .subscribeOn(rx.executor)
            .observeOn(rx.observer)
            .map(mapper::map)
            .subscribe({
                sendEvent(PersonEvent.ShowUser(it))
            }, {
                val message = it.localizedMessage.orEmpty()
                sendEvent(PersonEvent.ShowError(message))
            })
            .pool()
    }
}