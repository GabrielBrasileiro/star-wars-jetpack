package com.universodoandroid.starwarsjetpack.shared.mapper

interface Mapper<I, O> {
    fun map(enter: I): O
}