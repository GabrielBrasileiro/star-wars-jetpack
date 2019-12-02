package com.universodoandroid.starwarsjetpack.domain.session

import com.universodoandroid.starwarsjetpack.domain.session.cache.CacheType

interface CacheManager {
    fun isDownloaded(reference: CacheType): Boolean
    fun registerCache(reference: CacheType, isCached: Boolean)
}