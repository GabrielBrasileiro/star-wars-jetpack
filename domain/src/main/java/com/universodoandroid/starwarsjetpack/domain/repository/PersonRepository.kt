package com.universodoandroid.starwarsjetpack.domain.repository

import com.universodoandroid.starwarsjetpack.domain.common.BaseRepository
import com.universodoandroid.starwarsjetpack.domain.entities.Person

interface PersonRepository : BaseRepository {
    fun loadPeople(onSuccess: (List<Person>) -> Unit, onError: (Throwable) -> Unit)
    fun loadPerson(id: String, onSuccess: (Person) -> Unit, onError: (Throwable) -> Unit)
    fun savePeople(people: List<Person>, onComplete: () -> Unit, onError: (Throwable) -> Unit)
}