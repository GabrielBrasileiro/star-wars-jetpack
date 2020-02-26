package com.universodoandroid.starwarsjetpack.presentation.people.models.person

import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPersonUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PeopleMapper
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PersonDetailsViewModel(
    private val getPersonUseCase: GetPersonUseCase
) : BaseViewModel<PersonState>() {

    fun loadPerson(id: String) {
        getPersonUseCase.loadPerson(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val personDto = PeopleMapper.entityToDto(it)
                setState(PersonState.ShowUser(personDto))
            }, {
                setState(PersonState.ShowError(it.localizedMessage))
            })
            .pool()
    }

}