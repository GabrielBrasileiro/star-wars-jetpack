package com.universodoandroid.starwarsjetpack.local.people.database

import com.universodoandroid.starwarsjetpack.local.people.entity.PersonEntity
import io.reactivex.Completable
import io.reactivex.Flowable

internal interface PeopleDatabase {
    fun loadPeople(): Flowable<List<PersonEntity>>
    fun loadPerson(id: String): Flowable<PersonEntity>
    fun savePeople(people: List<PersonEntity>): Completable
    fun eraseData(): Completable
}