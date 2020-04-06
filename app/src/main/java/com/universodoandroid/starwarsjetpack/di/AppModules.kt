package com.universodoandroid.starwarsjetpack.di

import androidx.fragment.app.FragmentManager
import com.universodoandroid.starwarsjetpack.main.router.MainBottomNavRouter
import com.universodoandroid.starwarsjetpack.main.router.MainBottomNavRouterImpl
import org.koin.dsl.module

private val modules = module {
    factory<MainBottomNavRouter> { (supportFragment: FragmentManager) ->
        MainBottomNavRouterImpl(supportFragment)
    }
}

fun getAppModules() = listOf(modules)