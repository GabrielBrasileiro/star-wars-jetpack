package com.universodoandroid.starwarsjetpack.domain.repositories

import com.universodoandroid.starwarsjetpack.domain.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.entities.Person
import io.reactivex.Completable
import io.reactivex.Flowable


interface PeopleRepository {
    fun getPeople(): Flowable<List<Person>>
    fun getPeoplePerPage(page: Int): Flowable<PeoplePage>
    fun saveLocalPeople(people: List<Person>): Completable
    fun getPerson(id: String): Flowable<Person>
    fun eraseData(): Completable
}