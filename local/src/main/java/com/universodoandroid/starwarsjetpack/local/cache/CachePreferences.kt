package com.universodoandroid.starwarsjetpack.local.cache

internal interface CachePreferences {
    fun wasCached(reference: CacheType): Boolean
    fun registerCache(reference: CacheType, isCached: Boolean)
}
