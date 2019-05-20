package com.universodoandroid.presentation

class ViewState<D, E>(
    val status: Status,
    val data: D? = null,
    val error: E? = null
) {
    enum class Status {
        LOADING, SUCCESS, ERROR
    }
}