package com.universodoandroid.starwarsjetpack.data.datastore.people

import com.universodoandroid.starwarsjetpack.data.entities.PeoplePageData
import io.reactivex.Flowable

interface PeopleRemoteData {
    fun getAllPeopleData(): Flowable<PeoplePageData>
    fun getPeoplePerPage(page: Int): Flowable<PeoplePageData>
}