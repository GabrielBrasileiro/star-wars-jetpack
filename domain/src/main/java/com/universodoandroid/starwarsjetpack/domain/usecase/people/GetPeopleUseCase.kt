package com.universodoandroid.starwarsjetpack.domain.usecase.people

import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.domain.repositories.PeopleRepository
import io.reactivex.Flowable

class GetPeopleUseCase(
    private val repository: PeopleRepository
) {

    fun getPeople() : Flowable<List<Person>> {
        return repository.getPeople()
    }

}