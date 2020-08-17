package com.universodoandroid.starwarsjetpack.local.cache

import android.content.SharedPreferences
import com.universodoandroid.starwarsjetpack.local.ext.edit

internal class CachePreferencesImpl(
    private val sharedPreferences: SharedPreferences
) : CachePreferences {

    override fun wasCached(reference: CacheType): Boolean {
        return sharedPreferences.getBoolean(reference.id, false)
    }

    override fun registerCache(reference: CacheType, isCached: Boolean) {
        sharedPreferences.edit { putBoolean(reference.id, isCached) }
    }
}