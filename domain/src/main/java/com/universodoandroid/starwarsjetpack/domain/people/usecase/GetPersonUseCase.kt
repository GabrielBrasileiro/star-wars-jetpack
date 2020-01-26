package com.universodoandroid.starwarsjetpack.domain.people.usecase

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import io.reactivex.Flowable

class GetPersonUseCase(
    private val repository: PeopleRepository
) {

    fun loadPerson(id: String): Flowable<Person> {
        return repository.getPerson(id)
    }

}