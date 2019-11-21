package com.universodoandroid.local.local.person

import com.universodoandroid.domain.common.BaseFlowable
import com.universodoandroid.domain.entities.people.PeopleResponse
import com.universodoandroid.domain.entities.people.Person
import com.universodoandroid.domain.repository.PersonRepository
import com.universodoandroid.local.AppDatabase
import com.universodoandroid.local.mapper.PersonMapper

open class PersonDatabaseImpl(database: AppDatabase) : BaseFlowable(), PersonRepository {

    private val personDao = database.personDao()

    override fun savePeople(
        people: PeopleResponse,
        onComplete: () -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val peopleEntity = people.results.map { PersonMapper.toData(it) }

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