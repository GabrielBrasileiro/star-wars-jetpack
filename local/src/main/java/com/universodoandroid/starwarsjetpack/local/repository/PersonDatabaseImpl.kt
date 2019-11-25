package com.universodoandroid.starwarsjetpack.local.repository

import com.universodoandroid.starwarsjetpack.commons.BaseFlowable
import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.domain.repository.PersonRepository
import com.universodoandroid.starwarsjetpack.local.AppDatabase
import com.universodoandroid.starwarsjetpack.local.mapper.PersonMapper

open class PersonDatabaseImpl(database: AppDatabase) : com.universodoandroid.starwarsjetpack.commons.BaseFlowable(), PersonRepository {

    private val personDao = database.personDao()

    override fun savePeople(
        people: List<Person>,
        onComplete: () -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val peopleEntity = people.map { PersonMapper.toData(it) }

        buildCompletable(personDao.insertPeople(people = peopleEntity), onComplete, onError)
    }

    override fun loadPeople(onSuccess: (List<Person>) -> Unit, onError: (Throwable) -> Unit) {
        buildFlowable(personDao.getPeople(), {
            onSuccess(it.map { personEntity ->
                PersonMapper.fromData(personEntity)
            })
        }, onError)
    }

    override fun loadPerson(id: String, onSuccess: (Person) -> Unit, onError: (Throwable) -> Unit) {
        buildFlowable(personDao.getPerson(id), {
            onSuccess(PersonMapper.fromData(it))
        }, onError)
    }

    override fun dispose() = clear()

}