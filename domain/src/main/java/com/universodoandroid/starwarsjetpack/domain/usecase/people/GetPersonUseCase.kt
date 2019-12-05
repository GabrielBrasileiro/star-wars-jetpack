package com.universodoandroid.starwarsjetpack.domain.usecase.people

import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.domain.executors.BaseUseCaseExecutor
import com.universodoandroid.starwarsjetpack.domain.executors.PostExecutorThread
import com.universodoandroid.starwarsjetpack.domain.repositories.PeopleRepository

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