package com.universodoandroid.local

import com.universodoandroid.local.data.PersonRepository
import com.universodoandroid.local.entity.Person
import io.reactivex.Completable
import io.reactivex.Flowable

class PersonRoomRepository(database: AppDatabase) : PersonRepository {

    private val personDao = database.personDao()

    override fun savePerson(person: Person): Completable {
        return personDao.save(person = person)
    }

    override fun loadPeople(): Flowable<List<Person>> {
        return personDao.getPeople()
    }

}