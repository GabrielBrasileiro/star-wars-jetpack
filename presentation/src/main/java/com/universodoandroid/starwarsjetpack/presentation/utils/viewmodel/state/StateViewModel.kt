package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.State
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.ObservableViewModel

open class StateViewModel<S : State> : StateView<S>, ObservableViewModel() {

    private var state: MutableLiveData<S> = MutableLiveData()

    override fun getState(): LiveData<S> = state

    protected fun setState(_state: S) {
        state.value = _state
    }
}
