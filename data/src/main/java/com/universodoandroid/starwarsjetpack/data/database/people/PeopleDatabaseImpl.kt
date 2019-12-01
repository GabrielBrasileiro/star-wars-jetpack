package com.universodoandroid.starwarsjetpack.data.database.people

import com.universodoandroid.starwarsjetpack.data.AppDatabase
import com.universodoandroid.starwarsjetpack.data.entity.PersonEntity

internal class PeopleDatabaseImpl(database: AppDatabase) :
    PeopleDatabase {

    private val personDao = database.personDao()

    override fun loadPeople() = personDao.getPeople()

    override fun loadPerson(id: String) = personDao.getPerson(id)

    override fun savePeople(people: List<PersonEntity>) = personDao.insertPeople(people)

}