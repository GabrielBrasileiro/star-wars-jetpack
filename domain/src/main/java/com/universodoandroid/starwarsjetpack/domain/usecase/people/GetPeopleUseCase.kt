package com.universodoandroid.starwarsjetpack.domain.usecase.people

import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.domain.executors.BaseUseCaseExecutor
import com.universodoandroid.starwarsjetpack.domain.executors.PostExecutorThread
import com.universodoandroid.starwarsjetpack.domain.repositories.PeopleRepository

class GetPeopleUseCase(
    postExecutorThread: PostExecutorThread,
    private val repository: PeopleRepository
) : BaseUseCaseExecutor(postExecutorThread) {

    fun getPeople(onSuccess: (List<Person>) -> Unit, onError: (Throwable) -> Unit) {
        execute(repository.getPeople(), onSuccess, onError)
    }

}