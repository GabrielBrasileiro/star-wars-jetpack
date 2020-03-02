package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state

import androidx.lifecycle.LiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.State

internal interface StateView<S: State> {
    fun getState(): LiveData<S>
    fun setState(_state: S)
}