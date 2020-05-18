package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people

import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.usecase.GetPeopleUseCase
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.control.PeopleEvent
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.control.PeopleStateEvent
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.BaseViewModel
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.Reducer
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PeopleListViewModel(
    action: MutableLiveData<PeopleEvent>,
    reducer: Reducer<PeopleState, PeopleStateEvent>,
    private val getPeopleUseCase: GetPeopleUseCase,
    private val mapper: Mapper<Person, PersonPresentation>
) : BaseViewModel<PeopleState, PeopleEvent, PeopleStateEvent>(action, reducer) {

    init {
        loadPeople()
    }

    private fun loadPeople() {
        getPeopleUseCase.getPeople()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { setEvent(PeopleEvent.ShowLoading) }
            .doFinally { setEvent(PeopleEvent.HideLoading) }
            .subscribe({
                val peopleDto = it.map { person -> mapper.map(person) }
                updateTo(PeopleStateEvent.ShowPeopleData(peopleDto))
            }, {
                setEvent(PeopleEvent.ShowError(it.localizedMessage))
            })
            .pool()
    }
}