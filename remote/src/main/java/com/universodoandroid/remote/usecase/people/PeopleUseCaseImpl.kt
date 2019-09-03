package com.universodoandroid.remote.usecase.people

import android.app.Application
import com.universodoandroid.domain.people.Person
import com.universodoandroid.local.local.InjectionRepository
import com.universodoandroid.local.local.person.PersonRepository
import com.universodoandroid.remote.policy.PeoplePolicy

class PeopleUseCaseImpl(private val application: Application): PeopleUseCase {

    private val repository: PersonRepository by lazy {
        InjectionRepository.providePeopleRepository(application)
    }

    private val policy: PeoplePolicy by lazy {
        PeoplePolicy(application.applicationContext)
    }

    override fun getPeople(onSuccess: (List<Person>) -> Unit, onError: (error: Throwable) -> Unit) {
        repository.loadPeople({ people ->
            if (people.isEmpty()) {
                policy.firstSync(repository, onComplete = {
                    getPeople(onSuccess, onError)
                }, onError = onError)
            } else {
                onSuccess(people)
            }
        }, onError)
    }

    override fun updatePeople() {

    }

    override fun loadPerson(uuid: String, onSuccess: (Person) -> Unit, onError: (error: Throwable) -> Unit) {
        repository.loadPerson(uuid, onSuccess, onError)
    }

    override fun dispose() {
        repository.dispose()
    }

}