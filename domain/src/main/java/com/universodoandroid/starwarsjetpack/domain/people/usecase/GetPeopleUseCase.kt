package com.universodoandroid.starwarsjetpack.domain.people.usecase

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import io.reactivex.Flowable

class GetPeopleUseCase(
    private val repository: PeopleRepository
) {

    fun getPeople() : Flowable<List<Person>> {
        return repository.getPeople()
    }

}