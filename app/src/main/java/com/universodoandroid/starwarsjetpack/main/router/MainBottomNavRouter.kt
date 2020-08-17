package com.universodoandroid.starwarsjetpack.main.router

import androidx.annotation.IdRes

interface MainBottomNavRouter {
    fun navigateTo(@IdRes screen: Int): Boolean
}