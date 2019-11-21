package com.universodoandroid.domain.usecase.people

import com.universodoandroid.domain.entities.people.Person
import com.universodoandroid.domain.repository.PersonRepository

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