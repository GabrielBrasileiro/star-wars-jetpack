package com.universodoandroid.starwarsjetpack.presentation.navigation.model

import com.universodoandroid.starwarsjetpack.presentation.utils.viewmodel.state.State

data class NavigationState(
    val screenSelected: Int? = null
) : State
