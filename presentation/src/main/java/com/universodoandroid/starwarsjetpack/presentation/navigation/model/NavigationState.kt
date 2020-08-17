package com.universodoandroid.starwarsjetpack.presentation.navigation.model

import com.mvvmredux.core.state.State

data class NavigationState(
    val screenSelected: Int? = null
) : State
