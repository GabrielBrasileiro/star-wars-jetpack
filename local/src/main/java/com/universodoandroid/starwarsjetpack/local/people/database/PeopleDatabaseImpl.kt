package com.universodoandroid.starwarsjetpack.local.people.database

import com.universodoandroid.starwarsjetpack.local.people.dao.PersonDao
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity
import io.reactivex.Completable

internal class PeopleDatabaseImpl(
    private val dao: PersonDao
) : PeopleDatabase {

    override fun loadPeople() = dao.getPeople()

    override fun loadPerson(id: String) = dao.getPerson(id)

    override fun savePeople(people: List<PersonEntity>) = dao.insertPeople(people)

    override fun eraseData(): Completable = dao.eraseData()

}