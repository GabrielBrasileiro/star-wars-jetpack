package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person

import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person.model.PersonDetailsPresentation
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.event.EventViewModel
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PersonDetailsViewModel(
    event: MutableLiveData<PersonEvent>,
    private val getPersonUseCase: GetPersonUseCase,
    private val mapper: Mapper<Person, PersonDetailsPresentation>
) : EventViewModel<PersonEvent>(event) {

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