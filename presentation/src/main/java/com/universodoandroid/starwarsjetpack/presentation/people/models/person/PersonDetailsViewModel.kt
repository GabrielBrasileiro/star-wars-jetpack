package com.universodoandroid.starwarsjetpack.presentation.people.models.person

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDetailsDto
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel
import com.universodoandroid.starwarsjetpack.shared.extensions.Mapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PersonDetailsViewModel(
    private val getPersonUseCase: GetPersonUseCase,
    private val mapper: Mapper<Person, PersonDetailsDto>
) : BaseViewModel<PersonState>() {

    fun loadPerson(id: String) {
        getPersonUseCase.loadPerson(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val personDto = mapper.map(it)
                setState(PersonState.ShowUser(personDto))
            }, {
                setState(PersonState.ShowError(it.localizedMessage))
            })
            .pool()
    }

}