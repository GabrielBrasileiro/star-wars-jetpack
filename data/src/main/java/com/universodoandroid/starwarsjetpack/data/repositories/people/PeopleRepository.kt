package com.universodoandroid.starwarsjetpack.data.repositories.people

import com.universodoandroid.starwarsjetpack.data.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.data.entities.Person
import io.reactivex.Completable
import io.reactivex.Flowable


interface PeopleRepository {
    fun getLocalPeople(): Flowable<List<Person>>
    fun getRemotePeoplePerPage(page: Int): Flowable<PeoplePage>
    fun saveLocalPeople(people: List<Person>): Completable
    fun getPerson(id: String): Flowable<Person>
    fun eraseData(): Completable
}