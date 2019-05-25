package com.universodoandroid.remote.policy

import android.content.Context
import com.universodoandroid.local.local.person.PersonRepository
import com.universodoandroid.remote.preferences.PeopleDataSourcePreferences
import com.universodoandroid.remote.remote.InjectionRemoteDataSource
import com.universodoandroid.remote.remote.people.PeopleRemoteDataSource

class PeoplePolicy(private val context: Context) : Policy<PersonRepository> {

    private val remote: PeopleRemoteDataSource by lazy {
        InjectionRemoteDataSource.providePeopleRemoteDataSource()
    }

    private val preferences: PeopleDataSourcePreferences by lazy {
        PeopleDataSourcePreferences(context)
    }

    private val errors: ArrayList<Int> by lazy { ArrayList<Int>() }

    override fun firstSync(local: PersonRepository, onComplete: () -> Unit, onError: (Throwable) -> Unit) {
        loadPeoplePerPage(1, local, onComplete, onError)
    }

    override fun update(local: PersonRepository) {
        return
    }

    private fun loadPeoplePerPage(
        page: Int,
        local: PersonRepository,
        onComplete: () -> Unit,
        onError: (Throwable) -> Unit
    ) {
        remote.loadPeople(page, {
            local.savePeople(it, onComplete = {
                if (it.next != null) {
                    loadPeoplePerPage(page + 1, local, onComplete, onError)
                } else {
                    updateErrorRegister()
                    onComplete()
                }
            }) { error ->
                loadPeoplePerPage(page + 1, local, onComplete, onError)
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

    private fun updateErrorRegister() {
        preferences.errors = errors
    }

}