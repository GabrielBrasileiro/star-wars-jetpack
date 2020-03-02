package com.universodoandroid.starwarsjetpack.domain.people.usecase

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import io.reactivex.Single

class GetPersonUseCase(
    private val repository: PeopleRepository
) {

    fun loadPerson(id: String): Single<Person> {
        return repository.getPerson(id)
    }

}