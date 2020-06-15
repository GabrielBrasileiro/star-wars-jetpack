package com.universodoandroid.starwarsjetpack.extensions

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment

inline fun <reified A : Activity> Fragment.startActivity(params: Intent.() -> Unit = {}) {
    context?.startActivity<A>(params)
}