package com.universodoandroid.starwarsjetpack.main.utils

import com.universodoandroid.starwarsjetpack.domain.people.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import java.lang.Exception

object RepositoryMock {

    inline fun setupPeopleResult(crossinline expectedList: () -> Single<List<Person>>) {
        loadKoinModules(
            module {
                factory<PeopleRepository>(override = true) {
                    object : PeopleRepository {
                        override fun getPeople(): Single<List<Person>> {
                            return expectedList.invoke()
                        }

                        override fun getPeoplePerPage(page: Int): Flowable<PeoplePage> {
                            throw Exception("Not yet Implemented")
                        }

                        override fun saveLocalPeople(people: List<Person>): Completable {
                            throw Exception("Not yet Implemented")
                        }

                        override fun getPerson(id: String): Single<Person> {
                            throw Exception("Not yet Implemented")
                        }

                        override fun eraseData(): Completable {
                            throw Exception("Not yet Implemented")
                        }
                    }
                }
            }
        )
    }
}