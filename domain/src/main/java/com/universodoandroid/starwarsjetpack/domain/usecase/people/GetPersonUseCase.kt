package com.universodoandroid.starwarsjetpack.domain.usecase.people

import com.universodoandroid.starwarsjetpack.data.entities.Person
import com.universodoandroid.starwarsjetpack.data.repositories.people.PeopleRepository
import com.universodoandroid.starwarsjetpack.domain.executors.BaseUseCaseExecutor
import com.universodoandroid.starwarsjetpack.domain.executors.PostExecutorThread

class GetPersonUseCase(
    postExecutionThread: PostExecutorThread,
    private val repository: PeopleRepository
) : BaseUseCaseExecutor(postExecutionThread) {

    fun loadPerson(id: String, onSuccess: (Person) -> Unit, onError: (Throwable) -> Unit) {
        execute(repository.getPerson(id), {
            onSuccess(it)
        }, {
            onError(it)
        })
    }

}