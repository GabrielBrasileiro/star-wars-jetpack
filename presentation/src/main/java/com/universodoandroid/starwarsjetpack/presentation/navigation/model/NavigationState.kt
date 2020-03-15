package com.universodoandroid.starwarsjetpack.presentation.navigation.model

import com.universodoandroid.starwarsjetpack.presentation.utils.livedata.State

data class NavigationState(
    val showNavBar: Boolean = true
) : State
