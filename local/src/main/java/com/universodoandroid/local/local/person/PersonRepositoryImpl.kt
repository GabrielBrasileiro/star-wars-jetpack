package com.universodoandroid.local.local.person

import android.annotation.SuppressLint
import com.universodoandroid.domain.people.PeopleResponse
import com.universodoandroid.domain.people.Person
import com.universodoandroid.local.AppDatabase
import com.universodoandroid.local.dao.PersonDao
import com.universodoandroid.local.mapper.PersonMapper
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class PersonRepositoryImpl(private val personDao: PersonDao) : PersonRepository {

    override fun savePeople(people: PeopleResponse, onComplete: () -> Unit, onError: (Throwable) -> Unit) {
        val peopleEntity = people.results.map { personResponse ->
            PersonMapper.toData(person = personResponse)
        }

        personDao.insertPeople(people = peopleEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onComplete, onError)
    }

    override fun loadPeople(onSuccess: (List<Person>) -> Unit, onError: (Throwable) -> Unit) {
        personDao.getPeople()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(it.map { personEntity ->
                    PersonMapper.fromData(personEntity)
                })
            }, onError)
    }

    override fun loadPerson(id: String, onSuccess: (Person) -> Unit, onError: (Throwable) -> Unit) {
        personDao.getPerson(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(PersonMapper.fromData(it))
            }, onError)
    }


}