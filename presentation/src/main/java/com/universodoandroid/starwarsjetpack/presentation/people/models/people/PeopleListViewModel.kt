package com.universodoandroid.starwarsjetpack.presentation.people.models.people

import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.mapper.PeopleMapper
import com.universodoandroid.starwarsjetpack.presentation.utils.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PeopleListViewModel(
    private val getPeopleUseCase: GetPeopleUseCase
) : BaseViewModel<PeopleState>() {

    fun loadPeople() {
        getPeopleUseCase.getPeople()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { setState(PeopleState.ShowLoading) }
            .doFinally { setState(PeopleState.HideLoading) }
            .subscribe({
                val peopleDto = PeopleMapper.entityToDto(entities = it)
                setState(PeopleState.ShowData(peopleDto))
            }, {
                setState(PeopleState.ShowError(it.localizedMessage))
            })
            .pool()
    }

}