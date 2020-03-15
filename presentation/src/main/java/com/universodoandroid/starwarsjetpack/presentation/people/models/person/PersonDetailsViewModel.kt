package com.universodoandroid.starwarsjetpack.presentation.people.models.person

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDetailsPresentation
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.EventViewModel
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PersonDetailsViewModel(
    private val getPersonUseCase: GetPersonUseCase,
    private val mapper: Mapper<Person, PersonDetailsPresentation>
) : EventViewModel<PersonEvent>() {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadPerson(id: String) {
        getPersonUseCase.loadPerson(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val personDto = mapper.map(it)
                setEvent(PersonEvent.ShowUser(personDto))
            }, {
                setEvent(PersonEvent.ShowError(it.localizedMessage))
            })
            .pool()
    }
}