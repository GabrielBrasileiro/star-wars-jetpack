package com.universodoandroid.starwarsjetpack.data.repositories.people

import com.universodoandroid.starwarsjetpack.data.mapper.PersonMapper
import com.universodoandroid.starwarsjetpack.domain.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.remote.remote.people.PeopleRemoteDataSource
import io.reactivex.Flowable

internal class PeopleRemoteImpl(
    private val peopleRemoteDataSource: PeopleRemoteDataSource
) : PeopleDataStore {

    override fun getPeoplePerPage(page: Int): Flowable<PeoplePage> {
        return peopleRemoteDataSource.loadPeoplePerPage(page).map {
            PersonMapper.responseToPeoplePage(it)
        }
    }

    override fun getPeople(): Flowable<List<Person>> = throw UnsupportedOperationException()

    override fun savePeople(people: List<Person>) = throw UnsupportedOperationException()

    override fun getPerson(id: String) = throw UnsupportedOperationException()

}