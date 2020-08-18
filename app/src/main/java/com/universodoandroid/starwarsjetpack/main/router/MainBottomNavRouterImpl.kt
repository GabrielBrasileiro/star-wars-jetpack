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
        val isFragmentPresent = getFragments().map { it.tag }.contains(screen.toString())

        if (isFragmentPresent) {
            recoverFragment(screen, transaction)
        } else {
            addFragment(screen, transaction)
        }
    }

    private fun recoverFragment(screen: Int, transaction: FragmentTransaction) {
        getFragmentByTag(screen)?.run(transaction::show)
    }

    private fun addFragment(screen: Int, transaction: FragmentTransaction) {
        navFragment[screen]?.value?.let { fragment ->
            transaction.add(container, fragment, screen.toString())
        }
    }

    private fun hideFragmentIfPresent(transaction: FragmentTransaction) {
        getFragmentByTag(screenSelected)?.run(transaction::hide)
    }

    private fun getFragmentByTag(screen: Int?): Fragment? {
        return getFragments().find { it.tag == screen?.toString() }
    }

    private fun getFragments(): List<Fragment> = fragmentManager.fragments

}