package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state

import androidx.lifecycle.LiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.State

interface StateView<S : State> {
    fun getState(): LiveData<S>
}