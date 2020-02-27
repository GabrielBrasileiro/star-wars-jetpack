package com.universodoandroid.starwarsjetpack.local.people.data

import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleLocalData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.local.people.database.PeopleDatabase
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import io.reactivex.Completable
import io.reactivex.Single

internal class PeopleLocalDataImpl(
    private val localDataSource: PeopleDatabase,
    private val personDataMapper: Mapper<PersonEntity, PersonData>,
    private val personEntityMapper: Mapper<PersonData, PersonEntity>
) : PeopleLocalData {

    override fun getPeople(): Single<List<PersonData>> {
        return localDataSource.loadPeople().map {
            it.map { person -> personDataMapper.map(person) }
        }
    }

    override fun savePeople(people: List<PersonData>): Completable {
        val dataEntities = people.map { personEntityMapper.map(it) }
        return localDataSource.savePeople(dataEntities)
    }

    override fun getPerson(id: String): Single<PersonData> {
        return localDataSource.loadPerson(id).map { personDataMapper.map(it) }
    }

    override fun eraseData(): Completable {
        return localDataSource.eraseData()
    }
}
