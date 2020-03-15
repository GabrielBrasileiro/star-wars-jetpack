package com.universodoandroid.starwarsjetpack.local.cache

import android.content.SharedPreferences

internal class CachePreferencesImpl(
    private val sharedPreferences: SharedPreferences
) : CachePreferences {

    private val editor by lazy { sharedPreferences.edit() }

    override fun wasCached(reference: CacheType): Boolean {
        return sharedPreferences.getBoolean(reference.id, false)
    }

    override fun registerCache(reference: CacheType, isCached: Boolean) {
        editor.putBoolean(reference.id, isCached)
        editor.apply()
    }
}