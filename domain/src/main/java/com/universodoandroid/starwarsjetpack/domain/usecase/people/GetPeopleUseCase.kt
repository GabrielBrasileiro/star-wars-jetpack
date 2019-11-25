package com.universodoandroid.starwarsjetpack.domain.usecase.people

import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.domain.repository.PersonRepository

class GetPeopleUseCase(private val repository: PersonRepository) : PeopleUseCase {

    override fun getPeople(onSuccess: (List<Person>) -> Unit, onError: (error: Throwable) -> Unit) {
        repository.loadPeople(onSuccess, onError)
    }

    override fun updatePeople() {

    }

    override fun loadPerson(
        uuid: String,
        onSuccess: (Person) -> Unit,
        onError: (error: Throwable) -> Unit
    ) {
        repository.loadPerson(uuid, onSuccess, onError)
    }

    override fun dispose() = repository.dispose()

}