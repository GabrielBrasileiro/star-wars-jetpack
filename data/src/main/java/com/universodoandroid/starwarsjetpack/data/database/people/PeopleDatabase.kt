package com.universodoandroid.starwarsjetpack.data.database.people

import com.universodoandroid.starwarsjetpack.data.entity.PersonEntity
import io.reactivex.Completable
import io.reactivex.Flowable

internal interface PeopleDatabase {
    fun loadPeople(): Flowable<List<PersonEntity>>
    fun loadPerson(id: String): Flowable<PersonEntity>
    fun savePeople(people: List<PersonEntity>): Completable
}