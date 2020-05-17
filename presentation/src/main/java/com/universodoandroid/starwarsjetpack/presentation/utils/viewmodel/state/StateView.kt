package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state

import androidx.lifecycle.LiveData

interface StateView<S : State> {
    fun getState(): LiveData<S>
}