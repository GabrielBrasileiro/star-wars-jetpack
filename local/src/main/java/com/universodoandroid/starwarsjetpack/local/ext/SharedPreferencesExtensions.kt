package com.universodoandroid.starwarsjetpack.local.ext

import android.content.SharedPreferences


internal inline fun SharedPreferences.edit(editor: SharedPreferences.Editor.() -> Unit) {
    edit().apply(editor).apply()
}