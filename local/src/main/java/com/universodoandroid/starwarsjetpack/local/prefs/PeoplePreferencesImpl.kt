package com.universodoandroid.starwarsjetpack.local.prefs

import android.content.SharedPreferences
import com.universodoandroid.starwarsjetpack.data.people.datastore.people.PeoplePreferences
import com.universodoandroid.starwarsjetpack.data.global.CacheType

class PeoplePreferencesImpl(
    private val sharedPreferences: SharedPreferences
) : PeoplePreferences {

    private val editor by lazy { sharedPreferences.edit() }

    override fun isDownloaded(reference: CacheType): Boolean {
        return sharedPreferences.getBoolean(reference.id, false)
    }

    override fun registerCache(reference: CacheType, isCached: Boolean) {
        editor.putBoolean(reference.id, isCached)
        editor.apply()
    }

}