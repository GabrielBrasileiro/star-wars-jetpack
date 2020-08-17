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

        val beginTransaction = fragmentManager.beginTransaction()

        hideFragmentIfPresent(beginTransaction)
        showFragment(screen, beginTransaction)

        beginTransaction.commit()

        screenSelected = screen

        return true
    }

    private fun showFragment(screen: Int, transaction: FragmentTransaction) {
        if (isFragmentPresent(screen)) {
            getFragmentByTag(screen)?.run(transaction::show)
        } else {
            navFragment[screen]?.value?.let { frag ->
                transaction.add(container, frag, screen.toString())
            }
        }
    }

    private fun hideFragmentIfPresent(transaction: FragmentTransaction) {
        getFragmentByTag(screenSelected)?.run(transaction::hide)
    }

    private fun isFragmentPresent(screen: Int): Boolean {
        return fragmentManager.fragments.map { it.tag }.contains(screen.toString())
    }

    private fun getFragmentByTag(screen: Int?): Fragment? {
        return screen?.let { tag ->
            fragmentManager.fragments.forEach {
                if (it.tag == tag.toString()) {
                    return it
                }
            }

            return null
        }
    }
}