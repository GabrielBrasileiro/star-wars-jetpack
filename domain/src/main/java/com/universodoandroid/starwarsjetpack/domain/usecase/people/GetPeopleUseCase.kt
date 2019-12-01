package com.universodoandroid.starwarsjetpack.domain.usecase.people

import com.universodoandroid.starwarsjetpack.domain.common.executors.BaseUseCaseExecutor
import com.universodoandroid.starwarsjetpack.domain.common.executors.PostExecutorThread
import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.domain.repository.PeopleRepository
import com.universodoandroid.starwarsjetpack.domain.session.CacheManager
import com.universodoandroid.starwarsjetpack.domain.session.cache.CacheType

class GetPeopleUseCase(
    postExecutorThread: PostExecutorThread,
    private val repository: PeopleRepository,
    private val cacheManager: CacheManager
) : BaseUseCaseExecutor(postExecutorThread) {

    fun getPeople(onSuccess: (List<Person>) -> Unit, onError: (Throwable) -> Unit) {
        val isNotDownloaded = !cacheManager.isDownloaded(CacheType.PEOPLE_CACHE)

        if (isNotDownloaded)
            nextPage(1, onSuccess, { eraseData() })
        else
            getLocalPeople(onSuccess, onError)
    }

    private fun nextPage(
        page: Int,
        onSuccess: (List<Person>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        execute(repository.getRemotePeoplePerPage(page), {
            savePeople(it.people, {
                if (it.hasNextPage) {
                    nextPage(page + 1, onSuccess, onError)
                } else {
                    cacheManager.registerCache(CacheType.PEOPLE_CACHE, true)
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
        execute(repository.getLocalPeople(), onSuccess, onError)
    }

    private fun eraseData() {

    }

}