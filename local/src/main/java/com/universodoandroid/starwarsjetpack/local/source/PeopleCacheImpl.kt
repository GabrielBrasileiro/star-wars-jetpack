package com.universodoandroid.starwarsjetpack.local.source

import com.universodoandroid.starwarsjetpack.data.entities.Person
import com.universodoandroid.starwarsjetpack.data.repositories.people.PeopleDataStore
import com.universodoandroid.starwarsjetpack.local.database.people.PeopleDatabase
import com.universodoandroid.starwarsjetpack.local.mapper.PersonMapper
import io.reactivex.Completable
import io.reactivex.Flowable

internal class PeopleCacheImpl(
    private val localDataSource: PeopleDatabase
) : PeopleDataStore {

    override fun getPeople(): Flowable<List<Person>> {
        return localDataSource.loadPeople().map {
            PersonMapper.dataEntitiesToEntities(it)
        }
    }

    override fun savePeople(people: List<Person>): Completable {
        val dataEntities = PersonMapper.entitiesToDataEntities(people)
        return localDataSource.savePeople(dataEntities)
    }

    override fun getPerson(id: String): Flowable<Person> {
        return localDataSource.loadPerson(id).map {
            PersonMapper.fromData(it)
        }
    }

    override fun getPeoplePerPage(page: Int) = throw UnsupportedOperationException()

}