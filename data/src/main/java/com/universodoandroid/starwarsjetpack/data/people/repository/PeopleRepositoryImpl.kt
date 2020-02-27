package com.universodoandroid.starwarsjetpack.data.people.repository

import com.universodoandroid.starwarsjetpack.data.global.CacheType
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleLocalData
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeoplePreferences
import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.data.people.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.data.people.entities.PersonData
import com.universodoandroid.starwarsjetpack.domain.people.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import com.universodoandroid.starwarsjetpack.shared.extensions.Mapper
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

internal class PeopleRepositoryImpl(
    private val remote: PeopleRemoteData,
    private val local: PeopleLocalData,
    private val session: PeoplePreferences,
    private val peopleMapper: Mapper<PersonData, Person>,
    private val peopleDataMapper: Mapper<Person, PersonData>,
    private val peoplePageMapper: Mapper<PeoplePageData, PeoplePage>
) : PeopleRepository {

    override fun getPeople(): Single<List<Person>> {
        return if (session.isDownloaded(CacheType.PEOPLE_CACHE)) {
            local.getPeople().map(::dataToEntity)
        } else {
            remote.getAllPeopleData().flatMapCompletable {
                saveLocalPeople(it.people.map { person -> peopleMapper.map(person) })
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
        return remote.getPeoplePerPage(page).map { peoplePageMapper.map(it) }
    }

    override fun saveLocalPeople(people: List<Person>): Completable {
        val peopleData = people.map { peopleDataMapper.map(it) }
        return local.savePeople(peopleData)
    }

    override fun getPerson(id: String): Single<Person> {
        return local.getPerson(id).map { peopleMapper.map(it) }
    }

    override fun eraseData(): Completable {
        return local.eraseData()
    }

    private fun isCached(cached: Boolean) {
        session.registerCache(CacheType.PEOPLE_CACHE, cached)
    }

    private fun dataToEntity(people: List<PersonData>): List<Person> {
        return people.map { peopleMapper.map(it) }
    }
}