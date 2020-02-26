package com.universodoandroid.starwarsjetpack.data.utils

interface Mapper<in S, out O> {
    fun map(source: S): O
}