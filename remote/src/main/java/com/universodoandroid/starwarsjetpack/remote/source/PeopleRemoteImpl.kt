package com.universodoandroid.starwarsjetpack.remote.source

import com.universodoandroid.starwarsjetpack.data.datastore.people.PeopleDataStore
import com.universodoandroid.starwarsjetpack.data.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.entities.PersonData
import com.universodoandroid.starwarsjetpack.remote.mapper.PersonMapper
import com.universodoandroid.starwarsjetpack.remote.remote.people.PeopleRemoteDataSource
import io.reactivex.Flowable

internal class PeopleRemoteImpl(
    private val peopleRemoteDataSource: PeopleRemoteDataSource
) : PeopleDataStore {

    override fun getPeoplePerPage(page: Int): Flowable<PeoplePageData> {
        return peopleRemoteDataSource.loadPeoplePerPage(page).map {
            PersonMapper.responseToPeoplePage(it)
        }
    }

    override fun getPeople(): Flowable<List<PersonData>> = throw UnsupportedOperationException()

    override fun savePeople(people: List<PersonData>) = throw UnsupportedOperationException()

    override fun getPerson(id: String) = throw UnsupportedOperationException()

}