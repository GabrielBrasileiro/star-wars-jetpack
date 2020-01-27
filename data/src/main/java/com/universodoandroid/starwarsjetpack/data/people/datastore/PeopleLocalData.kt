package com.universodoandroid.starwarsjetpack.data.people.datastore

import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import io.reactivex.Completable
import io.reactivex.Flowable

interface PeopleLocalData {
    fun getPeople(): Flowable<List<PersonData>>
    fun savePeople(people: List<PersonData>): Completable
    fun getPerson(id: String): Flowable<PersonData>
    fun eraseData(): Completable
}