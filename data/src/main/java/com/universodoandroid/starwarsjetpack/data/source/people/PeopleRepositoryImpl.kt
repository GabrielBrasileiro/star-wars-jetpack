package com.universodoandroid.starwarsjetpack.data.source.people

import com.universodoandroid.starwarsjetpack.domain.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.data.datastore.people.PeopleDataStore
import com.universodoandroid.starwarsjetpack.data.entities.PersonData
import com.universodoandroid.starwarsjetpack.data.mappers.PeopleDataMapper
import com.universodoandroid.starwarsjetpack.domain.repositories.PeopleRepository
import io.reactivex.Completable
import io.reactivex.Flowable

internal class PeopleRepositoryImpl(
    private val remote: PeopleDataStore,
    private val local: PeopleDataStore
) : PeopleRepository {

    override fun getLocalPeople(): Flowable<List<Person>> {
        return local.getPeople().map { PeopleDataMapper.dataToEntities(it) }
    }

    override fun getRemotePeoplePerPage(page: Int): Flowable<PeoplePage> {
        return remote.getPeoplePerPage(page).map { PeopleDataMapper.entityPageToDataPage(it) }
    }

    override fun saveLocalPeople(people: List<Person>): Completable {
        val peopleData = people.map { PeopleDataMapper.entityToData(it) }

        return local.savePeople(peopleData)
    }

    override fun getPerson(id: String): Flowable<Person> {
        return local.getPerson(id).map { PeopleDataMapper.dataToEntity(it) }
    }

    override fun eraseData(): Completable = throw UnsupportedOperationException()

}