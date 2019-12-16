package com.universodoandroid.starwarsjetpack.domain.session

import com.universodoandroid.starwarsjetpack.domain.session.cache.CacheType

interface CacheData {
    fun isDownloaded(reference: CacheType): Boolean
    fun registerCache(reference: CacheType, isCached: Boolean)
}