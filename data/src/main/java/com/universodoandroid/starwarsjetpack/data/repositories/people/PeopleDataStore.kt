package com.universodoandroid.starwarsjetpack.data.repositories.people

import com.universodoandroid.starwarsjetpack.domain.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.entities.Person
import io.reactivex.Completable
import io.reactivex.Flowable

internal interface PeopleDataStore {
    fun getPeople(): Flowable<List<Person>>
    fun savePeople(people: List<Person>): Completable
    fun getPeoplePerPage(page: Int): Flowable<PeoplePage>
    fun getPerson(id: String): Flowable<Person>
}