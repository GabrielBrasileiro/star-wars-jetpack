package com.universodoandroid.starwarsjetpack.shared.extensions

inline fun <reified I, reified O> identifier(): String {
    val inputIdentifier = I::class.java.`package`.name + I::class.java.name
    val outputIdentifier = O::class.java.`package`.name + O::class.java.name

    return inputIdentifier + outputIdentifier
}
