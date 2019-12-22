package com.universodoandroid.starwarsjetpack.data.source.people

import com.universodoandroid.starwarsjetpack.data.datastore.people.PeopleLocalData
import com.universodoandroid.starwarsjetpack.data.datastore.people.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.data.entities.PersonData
import com.universodoandroid.starwarsjetpack.data.mappers.PeopleDataMapper
import com.universodoandroid.starwarsjetpack.domain.entities.PeoplePage
import com.universodoandroid.starwarsjetpack.domain.entities.Person
import com.universodoandroid.starwarsjetpack.domain.repositories.PeopleRepository
import com.universodoandroid.starwarsjetpack.domain.session.CacheData
import com.universodoandroid.starwarsjetpack.domain.session.cache.CacheType
import io.reactivex.Completable
import io.reactivex.Flowable

internal class PeopleRepositoryImpl(
    private val remote: PeopleRemoteData,
    private val local: PeopleLocalData,
    private val session: CacheData
) : PeopleRepository {

    override fun getPeople(): Flowable<List<Person>> {
        return if (session.isDownloaded(CacheType.PEOPLE_CACHE)) {
            local.getPeople().map(::dataToEntity)
        } else {
            remote.getAllPeopleData().flatMapCompletable {
                saveLocalPeople(it.people.map { person -> PeopleDataMapper.dataToEntity(person) })
            }.doOnComplete {
                session.registerCache(CacheType.PEOPLE_CACHE, true)
            }.andThen(
                local.getPeople().map(::dataToEntity)
            )
        }
    }

    private fun dataToEntity(people: List<PersonData>) = PeopleDataMapper.dataToEntities(people)

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

    override fun eraseData(): Completable = throw UnsupportedOperationException()

}