package com.universodoandroid.starwarsjetpack.main.router.di

import androidx.fragment.app.FragmentManager
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.main.router.MainBottomNavRouter
import com.universodoandroid.starwarsjetpack.main.router.MainBottomNavRouterImpl
import com.universodoandroid.starwarsjetpack.modules.people.PeopleFragment
import com.universodoandroid.starwarsjetpack.modules.planets.PlanetsFragment
import org.koin.dsl.module

internal val bottomFragments = mapOf(
    R.id.navigation_people to lazy { PeopleFragment() },
    R.id.navigation_planets to lazy { PlanetsFragment() }
)

private val modules = module {
    factory<MainBottomNavRouter> { (screenSelected: Int?, supportFragment: FragmentManager) ->
        MainBottomNavRouterImpl(R.id.container, screenSelected, supportFragment, bottomFragments)
    }
}

fun getBottomNavigationModules() = listOf(modules)