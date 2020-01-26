package com.universodoandroid.starwarsjetpack.local.people.database

import com.universodoandroid.starwarsjetpack.local.AppDatabase
import com.universodoandroid.starwarsjetpack.local.people.entity.PersonEntity
import io.reactivex.Completable

internal class PeopleDatabaseImpl(
    database: AppDatabase
) : PeopleDatabase {

    private val personDao = database.personDao()

    override fun loadPeople() = personDao.getPeople()

    override fun loadPerson(id: String) = personDao.getPerson(id)

    override fun savePeople(people: List<PersonEntity>) = personDao.insertPeople(people)

    override fun eraseData(): Completable = personDao.eraseData()

}