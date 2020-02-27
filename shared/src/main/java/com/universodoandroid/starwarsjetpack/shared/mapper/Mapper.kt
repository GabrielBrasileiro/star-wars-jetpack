package com.universodoandroid.starwarsjetpack.shared.mapper

interface Mapper<in E, out O> {
    fun map(enter: E): O
}