package com.universodoandroid.starwarsjetpack.domain.usecase.people

import com.universodoandroid.starwarsjetpack.domain.common.executors.BaseUseCaseExecutor
import com.universodoandroid.starwarsjetpack.domain.common.executors.PostExecutorThread
import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.domain.repository.PeopleRepository

class GetFirstSyncPeopleUseCase(
    postExecutorThread: PostExecutorThread,
    private val repository: PeopleRepository
) : BaseUseCaseExecutor(postExecutorThread) {

    fun getPeople(onSuccess: (List<Person>) -> Unit, onError: (Throwable) -> Unit) {
        execute(repository.getRemotePeoplePerPage(1), {
            onSuccess(it.people)
        }, {
            onError(it)
        })
    }

}