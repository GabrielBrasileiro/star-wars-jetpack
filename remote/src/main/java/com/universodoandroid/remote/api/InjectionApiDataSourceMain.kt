package com.universodoandroid.remote.api

class InjectionApiDataSourceMain {

    companion object {

        private fun provideApiDataSource(): ApiDataSource {
            val baseUrl = "https://swapi.co/api/"
            return ApiDataSource.getInstance(baseUrl)
        }

        fun providePeopleApiDataSource(): PeopleApiDataSource {
            return provideApiDataSource().createService(PeopleApiDataSource::class.java)
        }

    }

}