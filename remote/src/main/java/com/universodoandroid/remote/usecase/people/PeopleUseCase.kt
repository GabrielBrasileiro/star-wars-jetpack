package com.universodoandroid.remote.usecase.people

import com.universodoandroid.domain.people.Person

interface PeopleUseCase {
    fun getPeople(onSuccess: (List<Person>) -> Unit, onError: (error: Throwable) -> Unit)
    fun loadPerson(uuid: String, onSuccess: (Person) -> Unit, onError: (error: Throwable) -> Unit)
    fun updatePeople()
    fun dispose()
}