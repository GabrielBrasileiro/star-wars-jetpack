package com.universodoandroid.starwarsjetpack.shared.extensions

interface Mapper<in E, out O> {
    fun map(enter: E): O
}