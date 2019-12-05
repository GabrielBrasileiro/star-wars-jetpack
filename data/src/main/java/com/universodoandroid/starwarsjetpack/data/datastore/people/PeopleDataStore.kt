package com.universodoandroid.starwarsjetpack.data.datastore.people

import com.universodoandroid.starwarsjetpack.data.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.entities.PersonData
import io.reactivex.Completable
import io.reactivex.Flowable

interface PeopleDataStore {
    fun getPeople(): Flowable<List<PersonData>>
    fun savePeople(people: List<PersonData>): Completable
    fun getPeoplePerPage(page: Int): Flowable<PeoplePageData>
    fun getPerson(id: String): Flowable<PersonData>
}