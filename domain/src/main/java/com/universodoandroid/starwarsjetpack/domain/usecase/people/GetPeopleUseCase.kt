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
        execute(repository.getPeople(), {
            onSuccess(it)
        }, {
            onError(it)
        })
    }

    private fun nextPage(
        page: Int,
        onSuccess: (List<Person>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        execute(repository.getPeoplePerPage(page), {
            savePeople(it.people, {
                if (it.hasNextPage) {
                    nextPage(page + 1, onSuccess, onError)
                } else {
                    getLocalPeople(onSuccess, onError)
                }
            }, onError)
        }, onError)
    }

    private fun savePeople(
        people: List<Person>,
        onSuccess: () -> Unit,
        onError: (Throwable) -> Unit
    ) {
        execute(repository.saveLocalPeople(people), onSuccess, onError)
    }

    private fun getLocalPeople(onSuccess: (List<Person>) -> Unit, onError: (Throwable) -> Unit) {
        execute(repository.getPeople(), onSuccess, onError)
    }

    private fun eraseData() {

    }

}