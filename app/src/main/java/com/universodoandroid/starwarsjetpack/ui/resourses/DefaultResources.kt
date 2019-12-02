package com.universodoandroid.starwarsjetpack.ui.resourses

import android.content.res.Configuration
import android.content.res.Resources

fun Resources.defaultNumberOfColumns(): Int {
    return if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        1
    } else {
        2
    }
}