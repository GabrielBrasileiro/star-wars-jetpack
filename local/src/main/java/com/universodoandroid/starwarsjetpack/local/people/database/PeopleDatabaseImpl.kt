package com.universodoandroid.starwarsjetpack.local.people.database

import com.universodoandroid.starwarsjetpack.local.people.dao.PersonDao
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity
import io.reactivex.Completable
import io.reactivex.Single

internal class PeopleDatabaseImpl(
    private val dao: PersonDao
) : PeopleDatabase {

    override fun loadPeople(): Single<List<PersonEntity>> {
        return dao.getPeople()
    }

    override fun loadPerson(id: String): Single<PersonEntity> {
        return dao.getPerson(id)
    }

    override fun savePeople(people: List<PersonEntity>): Completable {
        return dao.insertPeople(people)
    }

    override fun deleteData(): Completable {
        return dao.deleteData()
    }
}