package com.universodoandroid.starwarsjetpack.data.repositories.people

import com.universodoandroid.starwarsjetpack.data.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.data.entities.Person
import io.reactivex.Completable
import io.reactivex.Flowable

interface PeopleDataStore {
    fun getPeople(): Flowable<List<Person>>
    fun savePeople(people: List<Person>): Completable
    fun getPeoplePerPage(page: Int): Flowable<PeoplePage>
    fun getPerson(id: String): Flowable<Person>
}