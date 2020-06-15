package com.universodoandroid.starwarsjetpack.local.people.data

import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleLocalData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.local.people.database.PeopleDatabase
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity
import com.universodoandroid.starwarsjetpack.local.cache.CachePreferences
import com.universodoandroid.starwarsjetpack.local.cache.CacheType
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import io.reactivex.Completable
import io.reactivex.Single

internal class PeopleLocalDataImpl(
    private val database: PeopleDatabase,
    private val preferences: CachePreferences,
    private val personDataMapper: Mapper<PersonEntity, PersonData>,
    private val personEntityMapper: Mapper<PersonData, PersonEntity>
) : PeopleLocalData {

    override fun getPeople(): Single<List<PersonData>> {
        return database.loadPeople().map { it.map(personDataMapper::map) }
    }

    override fun savePeople(people: List<PersonData>): Completable {
        val dataEntities = people.map(personEntityMapper::map)
        return database.savePeople(dataEntities)
    }

    override fun getPerson(id: String): Single<PersonData> {
        return database.loadPerson(id).map(personDataMapper::map)
    }

    override fun deleteData(): Completable {
        return database.deleteData()
    }

    override fun wasCached(): Boolean {
        return preferences.wasCached(CacheType.PEOPLE_CACHE)
    }

    override fun registerCache(wasDownloaded: Boolean) {
        preferences.registerCache(CacheType.PEOPLE_CACHE, wasDownloaded)
    }
}
