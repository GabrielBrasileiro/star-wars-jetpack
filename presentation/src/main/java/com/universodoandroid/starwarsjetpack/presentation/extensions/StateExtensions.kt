package com.universodoandroid.starwarsjetpack.presentation.extensions

import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.State
import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.StateView

fun <S : State> StateView<S>.requireStateValue(): S {
    return requireNotNull(getState().value)
}