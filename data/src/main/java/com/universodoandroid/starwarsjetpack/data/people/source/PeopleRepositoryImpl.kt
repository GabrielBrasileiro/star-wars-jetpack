package com.universodoandroid.starwarsjetpack.data.people.source

import com.universodoandroid.starwarsjetpack.data.people.datastore.people.PeopleLocalData
import com.universodoandroid.starwarsjetpack.data.people.datastore.people.PeoplePreferences
import com.universodoandroid.starwarsjetpack.data.people.datastore.people.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.data.people.mappers.PeopleDataMapper
import com.universodoandroid.starwarsjetpack.domain.people.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import com.universodoandroid.starwarsjetpack.data.global.CacheType
import io.reactivex.Completable
import io.reactivex.Flowable

internal class PeopleRepositoryImpl(
    private val remote: PeopleRemoteData,
    private val local: PeopleLocalData,
    private val session: PeoplePreferences
) : PeopleRepository {

    override fun getPeople(): Flowable<List<Person>> {
        return if (session.isDownloaded(CacheType.PEOPLE_CACHE)) {
            local.getPeople().map(::dataToEntity)
        } else {
            remote.getAllPeopleData().flatMapCompletable {
                saveLocalPeople(it.people.map { person -> PeopleDataMapper.dataToEntity(person) })
            }.doOnComplete {
                isCached(true)
            }.doOnError {
                isCached(false)
                eraseData()
            }.andThen(
                local.getPeople().map(::dataToEntity)
            )
        }
    }

    override fun getPeoplePerPage(page: Int): Flowable<PeoplePage> {
        return remote.getPeoplePerPage(page).map { PeopleDataMapper.entityPageToDataPage(it) }
    }

    override fun saveLocalPeople(people: List<Person>): Completable {
        val peopleData = people.map { PeopleDataMapper.entityToData(it) }
        return local.savePeople(peopleData)
    }

    override fun getPerson(id: String): Flowable<Person> {
        return local.getPerson(id).map { PeopleDataMapper.dataToEntity(it) }
    }

    override fun eraseData(): Completable {
        return local.eraseData()
    }

    private fun isCached(cached: Boolean) {
        session.registerCache(CacheType.PEOPLE_CACHE, cached)
    }

    private fun dataToEntity(people: List<PersonData>) = PeopleDataMapper.dataToEntities(people)

}