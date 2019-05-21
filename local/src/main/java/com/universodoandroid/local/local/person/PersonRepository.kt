package com.universodoandroid.local.local.person

import com.universodoandroid.domain.people.PeopleResponse
import com.universodoandroid.domain.people.Person
import com.universodoandroid.local.mapper.PersonMapper
import io.reactivex.Flowable

interface PersonRepository {
    fun loadPeople(onSuccess: (List<Person>) -> Unit, onError: (Throwable) -> Unit)
    fun loadPerson(id: String, onSuccess: (Person) -> Unit, onError: (Throwable) -> Unit)
    fun savePeople(people: PeopleResponse, onComplete: () -> Unit, onError: (Throwable) -> Unit)
}