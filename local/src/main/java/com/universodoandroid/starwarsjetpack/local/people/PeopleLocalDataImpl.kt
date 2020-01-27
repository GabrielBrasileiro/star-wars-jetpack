package com.universodoandroid.starwarsjetpack.local.people

import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleLocalData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.local.people.database.PeopleDatabase
import com.universodoandroid.starwarsjetpack.local.people.mapper.PersonMapper
import io.reactivex.Completable
import io.reactivex.Flowable

internal class PeopleLocalDataImpl(
    private val localDataSource: PeopleDatabase
) : PeopleLocalData {

    override fun getPeople(): Flowable<List<PersonData>> {
        return localDataSource.loadPeople().map { PersonMapper.dataEntitiesToEntities(it) }
    }

    override fun savePeople(people: List<PersonData>): Completable {
        val dataEntities = PersonMapper.entitiesToDataEntities(people)
        return localDataSource.savePeople(dataEntities)
    }

    override fun getPerson(id: String): Flowable<PersonData> {
        return localDataSource.loadPerson(id).map { PersonMapper.fromData(it) }
    }

    override fun eraseData(): Completable {
        return localDataSource.eraseData()
    }

}