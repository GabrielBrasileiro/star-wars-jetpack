package com.universodoandroid.starwarsjetpack.data.source.people

import com.universodoandroid.starwarsjetpack.data.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.data.entities.Person
import com.universodoandroid.starwarsjetpack.data.repositories.people.PeopleDataStore
import com.universodoandroid.starwarsjetpack.data.repositories.people.PeopleRepository
import io.reactivex.Completable
import io.reactivex.Flowable

internal class PeopleRepositoryImpl(
    private val remote: PeopleDataStore,
    private val local: PeopleDataStore
) : PeopleRepository {

    override fun getLocalPeople(): Flowable<List<Person>> {
        return local.getPeople()
    }

    override fun getRemotePeoplePerPage(page: Int): Flowable<PeoplePage> {
        return remote.getPeoplePerPage(page)
    }

    override fun saveLocalPeople(people: List<Person>): Completable {
        return local.savePeople(people)
    }

    override fun getPerson(id: String): Flowable<Person> {
        return local.getPerson(id)
    }

    override fun eraseData(): Completable = throw UnsupportedOperationException()

}