package com.universodoandroid.starwarsjetpack.domain.usecase.people

import com.universodoandroid.starwarsjetpack.domain.entities.Person

interface PeopleUseCase {
    fun getPeople(onSuccess: (List<Person>) -> Unit, onError: (error: Throwable) -> Unit)
    fun loadPerson(uuid: String, onSuccess: (Person) -> Unit, onError: (error: Throwable) -> Unit)
    fun updatePeople()
    fun dispose()
}