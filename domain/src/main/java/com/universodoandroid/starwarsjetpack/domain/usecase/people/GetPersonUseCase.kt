package com.universodoandroid.starwarsjetpack.domain.usecase.people

import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.domain.repositories.PeopleRepository
import io.reactivex.Flowable

class GetPersonUseCase(
    private val repository: PeopleRepository
) {

    fun loadPerson(id: String): Flowable<Person> {
        return repository.getPerson(id)
    }

}