package com.universodoandroid.starwarsjetpack.remote.source

import com.universodoandroid.starwarsjetpack.data.datastore.people.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.data.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.remote.mapper.PersonMapper
import com.universodoandroid.starwarsjetpack.remote.remote.people.PeopleRemoteDataSource
import io.reactivex.Flowable

internal class PeopleRemoteDataImpl(
    private val peopleRemoteDataSource: PeopleRemoteDataSource
) : PeopleRemoteData {

    override fun getAllPeopleData(): Flowable<PeoplePageData> = sync(1)

    private fun sync(page: Int): Flowable<PeoplePageData> {
        return getPeoplePerPage(page).concatMap {
            if (it.hasNextPage) {
                return@concatMap Flowable.just(it).concatWith(sync(page + 1))
            } else {
                return@concatMap Flowable.just(it)
            }
        }
    }

    override fun getPeoplePerPage(page: Int): Flowable<PeoplePageData> {
        return peopleRemoteDataSource.loadPeoplePerPage(page).map {
            PersonMapper.responseToPeoplePage(it)
        }
    }

}