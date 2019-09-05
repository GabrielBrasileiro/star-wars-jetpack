package com.universodoandroid.remote.usecase.people

import com.universodoandroid.domain.people.Person
import com.universodoandroid.remote.policy.PeoplePolicy

class PeopleUseCaseImpl(private val policy: PeoplePolicy): PeopleUseCase {

    override fun getPeople(onSuccess: (List<Person>) -> Unit, onError: (error: Throwable) -> Unit) {
        policy.firstSyncComplete({
            onSuccess(it)
        }, {
            policy.firstSync(onComplete = { getPeople(onSuccess, onError) }, onError = onError)
        }, onError)
    }

    override fun updatePeople() {

    }

    override fun loadPerson(uuid: String, onSuccess: (Person) -> Unit, onError: (error: Throwable) -> Unit) {
        policy.loadPerson(uuid, onSuccess, onError)
    }

    override fun dispose() {
        policy.dispose()
    }

}