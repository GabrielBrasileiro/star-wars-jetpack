package com.universodoandroid.starwarsjetpack.main.router

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainBottomNavRouterImpl(
    @IdRes private val container: Int,
    private var screenSelected: Int?,
    private val fragmentManager: FragmentManager,
    private val navFragment: Map<Int, Lazy<Fragment>>
) : MainBottomNavRouter {

    override fun navigateTo(@IdRes screen: Int): Boolean {
        if (screen == screenSelected) return false

        val lastScreenSelected = navFragment[screenSelected]?.value
        val currentScreeSelected = navFragment[screen]?.value
        val beginTransaction = fragmentManager.beginTransaction()

        lastScreenSelected?.run { hideFragment(beginTransaction, this) }
        currentScreeSelected?.run { showFragment(beginTransaction, this) }

        screenSelected = screen

        beginTransaction.commit()

        return true
    }

    private fun showFragment(transaction: FragmentTransaction, fragment: Fragment) {
        if (fragmentManager.fragments.contains(fragment).not()) {
            transaction.add(container, fragment)
        } else {
            transaction.show(fragment)
        }
    }

    private fun hideFragment(transaction: FragmentTransaction, fragment: Fragment) {
        transaction.hide(fragment)
    }
}