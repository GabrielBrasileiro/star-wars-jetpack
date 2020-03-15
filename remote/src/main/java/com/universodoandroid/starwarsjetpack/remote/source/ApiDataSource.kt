package com.universodoandroid.starwarsjetpack.remote.source

internal interface ApiDataSource {
    fun <S> createService(serviceClass: Class<S>): S
}