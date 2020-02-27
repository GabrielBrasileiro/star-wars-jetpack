package com.universodoandroid.starwarsjetpack.presentation.people.models.people

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDto
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel
import com.universodoandroid.starwarsjetpack.shared.extensions.Mapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PeopleListViewModel(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val mapper: Mapper<Person, PersonDto>
) : BaseViewModel<PeopleState>() {

    fun loadPeople() {
        getPeopleUseCase.getPeople()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { setState(PeopleState.ShowLoading) }
            .doFinally { setState(PeopleState.HideLoading) }
            .subscribe({
                val peopleDto = it.map { person -> mapper.map(person) }
                setState(PeopleState.ShowData(peopleDto))
            }, {
                setState(PeopleState.ShowError(it.localizedMessage))
            })
            .pool()
    }

}