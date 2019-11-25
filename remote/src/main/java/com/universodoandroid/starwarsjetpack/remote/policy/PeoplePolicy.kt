package com.universodoandroid.starwarsjetpack.remote.policy

import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.domain.repository.PersonRepository
import com.universodoandroid.starwarsjetpack.remote.remote.people.PeopleRemoteDataSource

class PeoplePolicy(private val remote: PeopleRemoteDataSource,
                   private val local: PersonRepository
) {

    private val errors: ArrayList<Int> by lazy { ArrayList<Int>() }

    fun firstSyncComplete(complete: (List<Person>) -> Unit, notComplete: () -> Unit, onError: (Throwable) -> Unit) {
        local.loadPeople({
            if (it.isNotEmpty()) {
                complete(it)
            } else {
                notComplete()
            }
        }, onError)
    }

    fun loadPerson(uuid: String, onSuccess: (Person) -> Unit, onError: (error: Throwable) -> Unit) {
        local.loadPerson(uuid, onSuccess, onError)
    }

    fun firstSync(onComplete: () -> Unit, onError: (Throwable) -> Unit) {
        loadPeoplePerPage(1, onComplete, onError)
    }

    private fun loadPeoplePerPage(page: Int, onComplete: () -> Unit, onError: (Throwable) -> Unit) {
        remote.loadPeople(page, {
            local.savePeople(it, onComplete = {
                if (it.next != null) {
                    loadPeoplePerPage(page + 1, onComplete, onError)
                } else {
                    remote.dispose()

                    updateErrorRegister()
                    onComplete()
                }
            }) { error ->
                loadPeoplePerPage(page + 1, onComplete, onError)
                registerError(page, error, onError)
            }
        }) { error ->
            registerError(page, error, onError)
        }
    }

    private fun registerError(page: Int, error: Throwable, onError: (Throwable) -> Unit) {
        errors.add(page)
        onError(error)
    }

    fun dispose() {
        remote.dispose()
        local.dispose()
    }

    private fun updateErrorRegister() {
//        preferences.errors = errors
    }

}