package com.universodoandroid.starwarsjetpack.session

import android.content.Context
import com.universodoandroid.starwarsjetpack.domain.session.CacheManager
import com.universodoandroid.starwarsjetpack.domain.session.cache.CacheType

class CacheManagerImpl(context: Context) : CacheManager {

    private val managerName = "data_manager"
    private val preferences = context.getSharedPreferences(managerName, Context.MODE_PRIVATE)

    private val editor by lazy { preferences.edit() }

    override fun isDownloaded(reference: CacheType) = preferences.getBoolean(reference.id, false)

    override fun registerCache(reference: CacheType, isCached: Boolean) {
        editor.putBoolean(reference.id, isCached)
        editor.apply()
    }

}