package com.universodoandroid.local.data

import com.universodoandroid.local.entity.Person
import io.reactivex.Completable
import io.reactivex.Flowable

interface PersonRepository {
    fun savePerson(person: Person): Completable
    fun loadPeople() : Flowable<List<Person>>
}