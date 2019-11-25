package com.universodoandroid.starwarsjetpack.presentation.utils

class ViewState<D, E>(
    val status: Status,
    val data: D? = null,
    val error: E? = null
) {
    enum class Status {
        SUCCESS, ERROR
    }
}