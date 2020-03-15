package com.universodoandroid.starwarsjetpack.local.cache

import android.content.SharedPreferences
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CachePreferencesTest {

    private val sharedPreferences = mock<SharedPreferences>()
    private val sharedEditor = mock<SharedPreferences.Editor>()
    private val cacheType = mock<CacheType>()
    private val cachePreferences: CachePreferences = CachePreferencesImpl(sharedPreferences)

    @Before
    fun setup() {
        whenever(sharedPreferences.edit()).thenReturn(sharedEditor)
    }

    @Test
    fun `registerCache should apply reference`() {
        cachePreferences.registerCache(cacheType, true)

        verify(sharedEditor).putBoolean(cacheType.id, true)
    }

    @Test
    fun `wasDownloaded should return cache state`() {
        whenever(sharedPreferences.getBoolean(cacheType.id, false)).thenReturn(true)

        val result = cachePreferences.wasCached(cacheType)

        assertEquals(result, true)
    }
}