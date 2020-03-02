package com.universodoandroid.starwarsjetpack.domain.people.repository

import com.universodoandroid.starwarsjetpack.domain.people.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface PeopleRepository {
    fun getPeople(): Single<List<Person>>
    fun getPeoplePerPage(page: Int): Flowable<PeoplePage>
    fun saveLocalPeople(people: List<Person>): Completable
    fun getPerson(id: String): Single<Person>
    fun eraseData(): Completable
}