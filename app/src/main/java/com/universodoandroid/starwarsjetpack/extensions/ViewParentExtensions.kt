package com.universodoandroid.starwarsjetpack.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun <T> ViewGroup.inflate(
    @LayoutRes layoutResId: Int,
    attachToRoot: Boolean = false,
    definition: (View) -> T
): T {
    val inflater = LayoutInflater.from(context)
    val view = inflater.inflate(layoutResId, this, attachToRoot)

    return definition(view)
}