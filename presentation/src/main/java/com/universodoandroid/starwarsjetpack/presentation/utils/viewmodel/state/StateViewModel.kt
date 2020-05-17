package com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state

import androidx.lifecycle.LiveData
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.ObservableViewModel
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.reducer.Reducer

open class StateViewModel<S : State>(
    private val reducer: Reducer<S, *>
) : StateView<S>, ObservableViewModel() {

    override fun getState(): LiveData<S> = reducer.getState()
}
