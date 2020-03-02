package com.universodoandroid.starwarsjetpack.data.people.datastore

import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import io.reactivex.Completable
import io.reactivex.Single

interface PeopleLocalData {
    fun getPeople(): Single<List<PersonData>>
    fun savePeople(people: List<PersonData>): Completable
    fun getPerson(id: String): Single<PersonData>
    fun eraseData(): Completable
}