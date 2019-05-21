package com.universodoandroid.remote.usecase.people

import android.app.Application
import com.universodoandroid.domain.people.Person
import com.universodoandroid.local.local.InjectionRepository
import com.universodoandroid.local.local.person.PersonRepository
import com.universodoandroid.remote.policy.PeoplePolicy
import com.universodoandroid.remote.remote.InjectionRemoteDataSource
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSource

class PeopleUseCase(private val application: Application) {

    private val repository: PersonRepository by lazy {
        InjectionRepository.providePeopleRepository(application)
    }

    fun getPeople(onSuccess: (List<Person>) -> Unit, onError: (error: Throwable) -> Unit) {
        repository.loadPeople({ people ->
            if (people.isEmpty()) {
                PeoplePolicy().firstSync(repository, onComplete = {
                    getPeople(onSuccess, onError)
                }, onError = onError)
            } else {
                onSuccess(people)
            }
        }, onError)
    }

    fun updatePeople() {

    }

    fun loadPerson(uuid: String, onSuccess: (Person) -> Unit, onError: (error: Throwable) -> Unit) {
        repository.loadPerson(uuid, onSuccess, onError)
    }

}