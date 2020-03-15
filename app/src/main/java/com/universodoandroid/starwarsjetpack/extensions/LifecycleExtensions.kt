package com.universodoandroid.starwarsjetpack.extensions

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

fun LifecycleOwner.addObserver(observer: LifecycleObserver) {
    lifecycle.addObserver(observer)
}