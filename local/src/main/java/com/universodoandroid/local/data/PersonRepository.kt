package com.universodoandroid.local.data

import com.universodoandroid.domain.people.PeopleResponse
import com.universodoandroid.local.entity.PersonEntity
import io.reactivex.Completable
import io.reactivex.Flowable

interface PersonRepository {
    fun savePerson(personEntity: PersonEntity): Completable
    fun loadPeople(): Flowable<List<PersonEntity>>
    fun savePeople(people: PeopleResponse)
}