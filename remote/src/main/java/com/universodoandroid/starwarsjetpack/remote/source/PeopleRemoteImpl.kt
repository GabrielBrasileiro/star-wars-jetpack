package com.universodoandroid.starwarsjetpack.remote.source

import com.universodoandroid.starwarsjetpack.data.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.data.entities.Person
import com.universodoandroid.starwarsjetpack.data.repositories.people.PeopleDataStore
import com.universodoandroid.starwarsjetpack.remote.mapper.PersonMapper
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