package com.universodoandroid.local

import com.universodoandroid.domain.people.PeopleResponse
import com.universodoandroid.local.data.PersonRepository
import com.universodoandroid.local.entity.PersonEntity
import com.universodoandroid.local.mapper.PersonMapper
import io.reactivex.Completable
import io.reactivex.Flowable

class PersonRoomRepository(database: AppDatabase) : PersonRepository {

    private val personDao = database.personDao()

    override fun savePeople(people: PeopleResponse) {
        people.results.map { personResponse ->
            PersonMapper.toData(person = personResponse)
        }.forEach { personEntity ->
            savePerson(personEntity)
        }
    }

    override fun savePerson(personEntity: PersonEntity): Completable {
        return personDao.save(personEntity = personEntity)
    }

    override fun loadPeople(): Flowable<List<PersonEntity>> {
        return personDao.getPeople()
    }

}