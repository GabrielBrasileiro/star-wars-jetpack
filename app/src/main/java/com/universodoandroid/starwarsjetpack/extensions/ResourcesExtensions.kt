package com.universodoandroid.starwarsjetpack.extensions

import android.content.res.Configuration
import android.content.res.Resources

fun Resources.defaultNumberOfColumns(): Int {
    return if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        1
    } else {
        2
    }
}