package com.universodoandroid.remote.preferences

import android.content.Context
import android.preference.PreferenceManager

class PeopleDataSourcePreferences(context: Context) {

    private val defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val errorKey = "people_errors"

    var errors: List<Int>
        get() {
            val strErrors = defaultSharedPreferences.getStringSet(errorKey, null) as? HashSet<String>
            return convertToInt(strErrors)
        }
        set(value) {
            val editor = defaultSharedPreferences.edit()
            val convertedErrors = convertToString(intArr = value)
            editor.putStringSet(errorKey, convertedErrors)
            editor.apply()
        }

    private fun convertToString(intArr: List<Int>?): HashSet<String> {
        val set = HashSet<String>()
        intArr?.forEach { set.add(it.toString()) }
        return set
    }

    private fun convertToInt(strArr: HashSet<String>?): List<Int> {
        val set = ArrayList<Int>()
        strArr?.forEach { set.add(it.toInt()) }
        return set
    }

}