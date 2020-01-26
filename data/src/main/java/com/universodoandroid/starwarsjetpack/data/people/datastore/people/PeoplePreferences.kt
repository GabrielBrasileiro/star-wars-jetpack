package com.universodoandroid.starwarsjetpack.data.people.datastore.people

import com.universodoandroid.starwarsjetpack.data.global.CacheType

interface PeoplePreferences {
    fun isDownloaded(reference: CacheType): Boolean
    fun registerCache(reference: CacheType, isCached: Boolean)
}