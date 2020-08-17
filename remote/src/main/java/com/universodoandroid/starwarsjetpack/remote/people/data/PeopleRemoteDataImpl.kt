package com.universodoandroid.starwarsjetpack.remote.people.data

import com.universodoandroid.starwarsjetpack.data.people.datastore.PeopleRemoteData
import com.universodoandroid.starwarsjetpack.data.people.entities.PeoplePageData
import com.universodoandroid.starwarsjetpack.remote.people.remote.PeopleRemoteDataSource
import com.universodoandroid.starwarsjetpack.remote.people.remote.response.PeopleResponse
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import io.reactivex.Flowable

internal class PeopleRemoteDataImpl(
    private val peopleRemoteDataSource: PeopleRemoteDataSource,
    private val mapper: Mapper<PeopleResponse, PeoplePageData>
) : PeopleRemoteData {

    override fun getAllPeopleData(): Flowable<PeoplePageData> = sync(FIRST_PAGE)

    private fun sync(page: Int): Flowable<PeoplePageData> {
        return getPeoplePerPage(page).concatMap {
            return@concatMap if (it.hasNextPage) {
                Flowable.just(it).concatWith(sync(page + 1))
            } else {
                Flowable.just(it)
            }
        }
    }

    override fun getPeoplePerPage(page: Int): Flowable<PeoplePageData> {
        return peopleRemoteDataSource.loadPeoplePerPage(page).map(mapper::map)
    }

    private companion object {
        const val FIRST_PAGE = 1
    }
}