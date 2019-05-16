package com.universodoandroid.remote.api

import com.universodoandroid.remote.BuildConfig

class InjectionApiDataSourceMain {

    companion object {

        private fun provideApiDataSource(): ApiDataSource {
            val baseUrl = BuildConfig.BASE_URL
            return ApiDataSource.getInstance(baseUrl)
        }

        fun providePeopleApiDataSource(): PeopleApiDataSource {
            return provideApiDataSource().createService(PeopleApiDataSource::class.java)
        }

    }

}