package com.universodoandroid.remote.policy

import com.universodoandroid.local.local.person.PersonRepository
import com.universodoandroid.remote.remote.InjectionRemoteDataSource
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSource

class PeoplePolicy : Policy<PersonRepository> {

    private val remote: PeopleRemoteDataSource by lazy {
        InjectionRemoteDataSource.providePeopleRemoteDataSource()
    }

    override fun firstSync(local: PersonRepository, onComplete: () -> Unit, onError: (Throwable) -> Unit) {
        remote.loadPeople({
            local.savePeople(it, onComplete, onError)
        }, onError)
    }

    override fun update(local: PersonRepository) {
        return
    }

}