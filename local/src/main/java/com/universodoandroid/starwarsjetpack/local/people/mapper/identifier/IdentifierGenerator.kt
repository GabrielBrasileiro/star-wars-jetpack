package com.universodoandroid.starwarsjetpack.local.people.mapper.identifier

import java.util.*

internal class IdentifierGenerator {

    fun getId(): String {
        return UUID.randomUUID().toString()
    }
}