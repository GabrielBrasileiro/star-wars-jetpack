package com.universodoandroid.domain.repository

import com.universodoandroid.domain.common.BaseRepository
import com.universodoandroid.domain.entities.people.PeopleResponse
import com.universodoandroid.domain.entities.people.Person

interface PersonRepository : BaseRepository {
    fun loadPeople(onSuccess: (List<Person>) -> Unit, onError: (Throwable) -> Unit)
    fun loadPerson(id: String, onSuccess: (Person) -> Unit, onError: (Throwable) -> Unit)
    fun savePeople(people: PeopleResponse, onComplete: () -> Unit, onError: (Throwable) -> Unit)
}