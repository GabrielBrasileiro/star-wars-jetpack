package com.universodoandroid.local.local.person

import com.universodoandroid.domain.people.PeopleResponse
import com.universodoandroid.domain.people.Person
import com.universodoandroid.local.dao.PersonDao
import com.universodoandroid.local.local.BaseFlowable
import com.universodoandroid.local.mapper.PersonMapper

open class PersonRepositoryImpl(private val personDao: PersonDao) : BaseFlowable(), PersonRepository {

    override fun savePeople(people: PeopleResponse, onComplete: () -> Unit, onError: (Throwable) -> Unit) {
        val peopleEntity = people.results.map { personResponse ->
            PersonMapper.toData(person = personResponse)
        }

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

    override fun dispose() {
        clear()
    }

}