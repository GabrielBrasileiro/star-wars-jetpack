package com.universodoandroid.starwarsjetpack.shared.mapper

interface Mapper<in I, out O> {
    fun map(enter: I): O
}