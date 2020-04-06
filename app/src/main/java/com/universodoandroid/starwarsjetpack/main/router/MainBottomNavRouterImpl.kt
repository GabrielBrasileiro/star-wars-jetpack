package com.universodoandroid.starwarsjetpack.main.router

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.modules.people.PeopleFragment
import com.universodoandroid.starwarsjetpack.modules.planets.PlanetsFragment

class MainBottomNavRouterImpl(
    private val supportFragmentManager: FragmentManager
) : MainBottomNavRouter {

    private var screenSelected: Int? = null

    private val bottomNavigationFragments = hashMapOf<Int, Lazy<Fragment>>(
        R.id.navigation_people to lazy { PeopleFragment() },
        R.id.navigation_planets to lazy { PlanetsFragment() }
    )

    override fun navigateTo(@IdRes screen: Int): Boolean {
        if (screen == screenSelected) return false

        val lastScreenSelected = bottomNavigationFragments[screenSelected]?.value
        val currentScreeSelected = bottomNavigationFragments[screen]?.value
        val beginTransaction = supportFragmentManager.beginTransaction()

        lastScreenSelected?.run { hideFragment(beginTransaction, this) }
        currentScreeSelected?.run { showFragment(beginTransaction, this) }

        screenSelected = screen

        beginTransaction.commitAllowingStateLoss()

        return true
    }

    override fun showPeopleFragment() {
        navigateTo(R.id.navigation_people)
    }

    private fun showFragment(transaction: FragmentTransaction, fragment: Fragment) {
        if (supportFragmentManager.fragments.contains(fragment).not()) {
            transaction.add(R.id.container, fragment)
        } else {
            transaction.show(fragment)
        }
    }

    private fun hideFragment(transaction: FragmentTransaction, fragment: Fragment) {
        transaction.hide(fragment)
    }
}