package com.universodoandroid.starwarsjetpack.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified A : Activity> Context.startActivity(params: Intent.() -> Unit = {}) {
    val intent = Intent(this, A::class.java).apply(params)
    startActivity(intent)
}